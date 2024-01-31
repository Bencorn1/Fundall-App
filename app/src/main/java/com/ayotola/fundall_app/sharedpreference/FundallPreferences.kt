package com.ayotola.fundall_app.sharedpreference

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson


class FundallPreferences (context: Context) : Preferences {

    override fun setEmail(email: String) {
        preferences.edit().putString(emailKey, email).apply()
    }

    override fun getEmail(): String {
        return preferences.getString(emailKey, "")!!
    }

    private val preferences = context.getSharedPreferences("datacapture", Context.MODE_PRIVATE)


    override fun setName(name: String) {
        preferences.edit().putString(nameKey, name).apply()
    }

    override fun getName(): String {
        return preferences.getString(nameKey, "")!!
    }

    override fun getToken(): String {
        return preferences.getString(tokenKey, "")!!
    }

    override fun setToken(token: String) {
        preferences.edit().putString(tokenKey, token).apply()
    }

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val emailKey = "com.ayotola.constants.emailId"
        private const val tokenKey = "com.ayotola.constants.tokenId"
        private const val nameKey = "com.ayotola.constants.name"
        private const val PREFS_NAME = "MyPrefs"
    }

}