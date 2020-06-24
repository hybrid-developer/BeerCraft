package com.zavaitar.feature.startup.presentation

import androidx.annotation.VisibleForTesting
import androidx.hilt.lifecycle.ViewModelInject
import com.zavaitar.core.mvi.MviViewModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import javax.inject.Inject

internal class StartupViewModel @ViewModelInject @VisibleForTesting constructor(
    state: StartupViewState,
    private val useCase: StartupUseCase
) : MviViewModel<StartupIntent, StartupResult, StartupViewState>(state) {

    constructor(useCase: StartupUseCase) : this(StartupViewState.default(), useCase)


    override fun dispatchIntent(intent: StartupIntent): Observable<StartupResult> = when (intent) {
        StartupIntent.Initialize -> initialize()
    }

    override fun filterIntents(intents: Observable<StartupIntent>): ObservableSource<StartupIntent> =
        Observable.merge(
            intents.ofType(StartupIntent.Initialize::class.java).take(1),
            intents.filter { !StartupIntent.Initialize::class.java.isInstance(it) }
        )

    fun initialize(): Observable<StartupResult> {
        return useCase.initialize()
            .toSingleDefault<StartupResult>(StartupResult.Initialized)
            .toObservable()
    }
}
