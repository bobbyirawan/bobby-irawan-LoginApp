package com.belajar.loginapp.api

import com.belajar.loginapp.helper.Constants.Companion.API_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class ApiInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Authorization", "Bearer $API_TOKEN")
            .build()
        return chain.proceed(request)
    }
}