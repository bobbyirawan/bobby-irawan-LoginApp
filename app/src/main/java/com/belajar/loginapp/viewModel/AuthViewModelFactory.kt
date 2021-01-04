package com.belajar.loginapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.belajar.loginapp.repository.Repository

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}