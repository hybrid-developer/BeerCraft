package com.zavaitar.feature.startup.presentation

import com.zavaitar.core.mvi.MviViewState

internal data class StartupViewState(val initialized: Boolean) : MviViewState {
    companion object {
        fun default(): StartupViewState = StartupViewState(initialized = false)
    }
}
