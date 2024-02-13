package com.ayotola.fundall_app.repository

import com.ayotola.fundall_app.LoginRequest
import com.ayotola.fundall_app.network.FundallService
import com.ayotola.fundall_app.sharedpreference.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class LoginRepo @Inject constructor(private val service: FundallService, private val preferences: Preferences, ) {

    suspend fun loginUser(token: String, request: LoginRequest) = withContext(Dispatchers.IO) {


        Timber.d("making request with id %s-----------------", request)
        try {
            val login = service.login(token = "Bearer $token", details = request)
//            val token = login.success?.user?.accessToken
//            if (token != null) {
//                preferences.setToken(token)
//            }

            Timber.d("response Success %s-----------------", login)
            login

        } catch (e: Exception) {
            Timber.d("response Error %s-----------------", e.message)
            throw e
        }
    }

}