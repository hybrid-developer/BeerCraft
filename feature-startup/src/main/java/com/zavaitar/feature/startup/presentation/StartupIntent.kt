package com.zavaitar.feature.startup.presentation

import com.zavaitar.core.mvi.MviIntent

internal sealed class StartupIntent : MviIntent {
    object Initialize : StartupIntent()
}
