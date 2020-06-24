package com.zavaitar.core.network

import android.content.Context
import com.zavaitar.core.network.interceptors.NoConnectionInterceptor
import javax.inject.Inject

class NetworkConfig @Inject constructor(private val context: Context) : NetworkConfigContract {

    override val interceptors by lazy {
        listOf(
            NoConnectionInterceptor(context)
        )
    }
}
