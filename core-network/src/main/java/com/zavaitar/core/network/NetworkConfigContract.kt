package com.zavaitar.core.network

import okhttp3.Interceptor

interface NetworkConfigContract {
    val interceptors: List<Interceptor>
}