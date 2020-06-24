package ${packageName}

import com.zavaitar.core.mvi.MviResult

internal sealed class ${className}Result : MviResult<${className}ViewState> {

    object Initialized : ${className}Result()

    override fun reduce(previousState: ${className}ViewState): ${className}ViewState {
        return when (this) {
            Initialized -> previousState.copy(initialized = true)
        }
    }
}
