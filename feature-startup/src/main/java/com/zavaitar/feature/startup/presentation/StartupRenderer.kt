package com.zavaitar.feature.startup.presentation

import com.zavaitar.core.mvi.MviRenderer

internal class StartupRenderer : MviRenderer<StartupView, StartupViewState> {
    override fun render(view: StartupView, viewState: StartupViewState) {
        if (viewState.initialized) {
            view.hideProgress()
        } else {
            view.showProgress()
        }
    }
}
