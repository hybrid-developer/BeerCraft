package com.zavaitar.core.network

import android.content.Context
import com.zavaitar.core.network.interceptors.NoConnectionInterceptor
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Inject

class NetworkConfig @Inject constructor(private val context: Context) : NetworkConfigContract {

    override val interceptors by lazy {
        listOf(
            NoConnectionInterceptor(context),
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY },
            ChuckInterceptor(context),
            StethoInterceptor()
        )
    }
}
