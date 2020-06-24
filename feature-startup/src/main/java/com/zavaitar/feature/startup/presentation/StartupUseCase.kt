package com.zavaitar.feature.startup.presentation

import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class StartupUseCase @Inject constructor() {

    fun initialize(): Completable {
        return Completable.complete()
            .delay(3L, TimeUnit.SECONDS)
    }
}
