package com.example.networkutil

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkSessionRequestInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        builder.addHeader("Accept-Language", "en-US")
        val request = builder.build()
        return chain.proceed(request)
    }
}