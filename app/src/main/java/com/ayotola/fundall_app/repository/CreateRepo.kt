package com.ayotola.fundall_app.repository

import com.ayotola.fundall_app.CreateUserRequest
import com.ayotola.fundall_app.network.FundallService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import timber.log.Timber
import javax.inject.Inject

class CreateRepo @Inject constructor(private val service: FundallService) {

    suspend fun createUser(token: String, request: CreateUserRequest) = withContext(Dispatchers.IO) {

        Timber.d("making request with id %s-----------------", request)
        try {
            val response = service.createUser(token = "Bearer $token", details = request)
            Timber.d("response Success %s-----------------", response)
            response

        } catch (e: Exception) {
            Timber.d("response Error %s-----------------", e.message)
            throw e
        }
    }

}