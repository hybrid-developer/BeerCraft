package com.zavaitar.feature.startup.presentation

import com.zavaitar.core.mvi.MviResult

internal sealed class StartupResult : MviResult<StartupViewState> {

    object Initialized : StartupResult()

    override fun reduce(previousState: StartupViewState): StartupViewState {
        return when (this) {
            Initialized -> previousState.copy(initialized = true)
        }
    }
}
