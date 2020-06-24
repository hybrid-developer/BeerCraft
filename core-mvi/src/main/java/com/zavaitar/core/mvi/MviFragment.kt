package com.zavaitar.core.mvi

import android.content.Context
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

/**
 * The Fragment Android Framework that applies the MVI pattern.
 */
abstract class MviFragment<V : MviView, I : MviIntent, A : MviResult<VS>, VS : MviViewState>(@LayoutRes layout: Int) :
    Fragment(layout),
    MviView {

    private val onStartDisposables = CompositeDisposable()
    private val onAttachDisposables = CompositeDisposable()

    /**
     * This activity should implement the provided MviView generic interface, it will be used by
     * the renderer to update the ui.
     */
    abstract val view: V

    /**
     * The ViewModel belonging to the fragment
     */
    abstract val viewModel: MviViewModel<I, A, VS>

    /**
     * The Renderer that will update the MviView of this fragment
     */
    abstract val renderer: MviRenderer<V, VS>

    /**
     * Push Intents to this
     */
    abstract fun onStartIntents(): Observable<I>

    /**
     * Push Intents to this
     */
    open fun onAttachIntents(): Observable<I> = Observable.empty()

    override fun onAttach(context: Context) = super.onAttach(context).also {
        onAttachDisposables.add(viewModel.processIntents(onAttachIntents()))
    }

    override fun onDetach() {
        onAttachDisposables.clear()
        super.onDetach()
    }

    override fun onStart() = super.onStart().also {
        onStartDisposables.addAll(
            viewModel.states()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { renderer.render(view, it) },
            viewModel.processIntents(onStartIntents())
        )
    }

    override fun onStop() {
        onStartDisposables.clear()
        super.onStop()
    }
}
