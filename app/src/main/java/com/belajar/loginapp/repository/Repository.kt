package com.belajar.loginapp.repository

import com.belajar.loginapp.api.ApiInstance
import com.belajar.loginapp.model.Login
import retrofit2.Response

class Repository {
    suspend fun postLogin(
        name: String,
        password: String
    ): Response<Login> {
        return ApiInstance.api.postLogin(name, password)
    }
}