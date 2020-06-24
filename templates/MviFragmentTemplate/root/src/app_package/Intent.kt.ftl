package ${packageName}

import com.zavaitar.core.mvi.MviIntent

internal sealed class ${className}Intent : MviIntent {
    object Initialize : ${className}Intent()
}
