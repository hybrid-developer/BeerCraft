package com.zavaitar.core.mvi

/**
 * Render an MviView based on the provided MviViewState.
 */
interface MviRenderer<V : MviView, VS : MviViewState> {

    /**
     * Update the MviView with the MviViewState
     */
    fun render(view: V, viewState: VS)

    fun onResume() {
        // default = no nothing
    }
}
