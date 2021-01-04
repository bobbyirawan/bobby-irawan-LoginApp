package com.belajar.loginapp.helper

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {

    //Nama Database untuk sharedPreferences
    private val PREF_NAME = "login"
    private var sharedPreferences: SharedPreferences
    val editor: SharedPreferences.Editor

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun put(key: String, value: String) {
        editor.putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value).apply()
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun clearAll() {
        editor.clear()
            .commit()
    }

}