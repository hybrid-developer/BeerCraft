package com.zavaitar.core.network.interceptors

import android.content.Context
import com.zavaitar.core.network.exceptions.NoConnectivityException
import com.zavaitar.core.network.exceptions.NoInternetException
import com.zavaitar.core.network.util.InternetConnection
import okhttp3.Interceptor
import okhttp3.Response

class NoConnectionInterceptor(private val context: Context) : Interceptor {

    @Throws(NoConnectivityException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        return if (!InternetConnection.isConnectionOn(context)) {
            throw NoConnectivityException()
        } else if (!InternetConnection.isInternetAvailable()) {
            throw NoInternetException()
        } else {
            chain.proceed(chain.request())
        }
    }
}
