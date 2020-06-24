package com.zavaitar.feature.startup.presentation

import com.zavaitar.core.mvi.MviView

internal interface StartupView : MviView {
    fun showProgress()
    fun hideProgress()
}
