package com.belajar.loginapp.api

import com.belajar.loginapp.model.Login
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Endpoint {
    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(
        @Field("name") name: String,
        @Field("password") password: String
    ): Response<Login>
}