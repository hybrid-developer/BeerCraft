package com.zavaitar.core.mvi

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject

/**
 * Listens for a user interface interaction intent and maps it into a MviViewState, as the registrationResponse of
 * some form of use case.
 * */
abstract class MviViewModel<I : MviIntent, A : MviResult<VS>, VS : MviViewState>(initialState: VS) : ViewModel() {

    private val intentsSubject: PublishSubject<I> = PublishSubject.create()
    private val statesObservable: Observable<VS> = intentsSubject
        .compose { intents -> intents.publish { shared -> filterIntents(shared) } }
        .flatMap { dispatchIntent(it) }
        .scan(initialState) { previousState: VS, result: A -> result.reduce(previousState) }
        .distinctUntilChanged()
        .replay(1)
        .autoConnect(0)

    abstract fun dispatchIntent(intent: I): Observable<A>

    open fun filterIntents(intents: Observable<I>): ObservableSource<I> = intents

    fun processIntents(intents: Observable<I>): Disposable {
        return intents.subscribe(intentsSubject::onNext)
    }

    fun states(): Observable<VS> = statesObservable
}
