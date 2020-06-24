package com.zavaitar.core.mvi

interface MviResult<VS> {
    fun reduce(previousState: VS): VS
}
