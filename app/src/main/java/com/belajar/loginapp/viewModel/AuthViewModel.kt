package com.belajar.loginapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.belajar.loginapp.model.Login
import com.belajar.loginapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel(private val repository: Repository) : ViewModel() {

    val loginResponse: MutableLiveData<Response<Login>> = MutableLiveData()

    fun postLogin(username: String, password: String) {
        viewModelScope.launch {
            val response = repository.postLogin(username, password)
            loginResponse.value = response
        }
    }

}