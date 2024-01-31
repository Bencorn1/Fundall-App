package com.ayotola.fundall_app.sharedpreference

interface Preferences {
    fun setName(name: String)
    fun getName(): String
    fun getToken(): String
    fun setToken(token: String)
    fun setEmail(email: String)
    fun getEmail(): String
}