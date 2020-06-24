package ${packageName}

import com.zavaitar.core.mvi.MviViewState

internal data class ${className}ViewState(val initialized: Boolean) : MviViewState {
    companion object {
        fun default(): ${className}ViewState = ${className}ViewState(initialized = false)
    }
}
