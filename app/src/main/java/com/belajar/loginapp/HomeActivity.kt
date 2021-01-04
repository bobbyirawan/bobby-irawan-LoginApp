package com.belajar.loginapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.belajar.loginapp.databinding.ActivityHomeBinding
import com.belajar.loginapp.helper.Constants
import com.belajar.loginapp.helper.Preferences

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var sharedPreferences: Preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = Preferences(this)
        binding.name.text = sharedPreferences.getString(Constants.PREF_USERNAME)



    }
}