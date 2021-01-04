package com.belajar.loginapp.api

import com.belajar.loginapp.helper.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    private val client = OkHttpClient.Builder().apply {
        addInterceptor(ApiInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: Endpoint by lazy {
        retrofit.create(Endpoint::class.java)
    }

}