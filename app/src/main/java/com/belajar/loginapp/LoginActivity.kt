package com.belajar.loginapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.belajar.loginapp.databinding.ActivityLoginBinding
import com.belajar.loginapp.helper.Constants
import com.belajar.loginapp.helper.Preferences
import com.belajar.loginapp.repository.Repository
import com.belajar.loginapp.viewModel.AuthViewModel
import com.belajar.loginapp.viewModel.AuthViewModelFactory

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding
    private lateinit var sharedPreferences: Preferences
    private lateinit var authViewModel: AuthViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = Preferences(this)
        val repository = Repository()
        val authViewModelFactory = AuthViewModelFactory(repository)
        authViewModel = ViewModelProvider(this, authViewModelFactory).get(AuthViewModel::class.java)
        binding.btnLogin.setOnClickListener {
            authentication()
        }


    }


    private fun authentication() {
        val username = binding.edtUsername.text
        val password = binding.edtPassword.text
        if (username.isNotEmpty() && password.isNotEmpty()) {
            authViewModel.postLogin(username.toString(), password.toString())
            authViewModel.loginResponse.observe(this, {
                if (it.isSuccessful) {
                    val token = it.body()?.token.toString()
                    val name = it.body()?.user?.name.toString()
                    saveSession(token, name)
                    moveHome()
                    showMessage("berhasil masuk")
                } else {
                    Log.d("AUTH", it.errorBody().toString())
                }
            })

        } else {
            showMessage("gagal masuk")
        }
    }

    private fun saveSession(token: String, username: String) {
        sharedPreferences.put(Constants.API_TOKEN, token)
        sharedPreferences.put(Constants.PREF_USERNAME, username)
        sharedPreferences.put(Constants.PREF_IS_LOGIN, true)
    }

    private fun moveHome() {
        Intent(this, HomeActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}