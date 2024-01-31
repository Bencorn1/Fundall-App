package com.ayotola.fundall_app

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface FundallService {

    @POST("register")
    suspend fun createUser(
        @Header("Authorization") token: String,
        @Body details: CreateUserRequest
    ): Response<CreateUserResponse>

//
//    @GET("capture/household/{id}/residents/")
//    suspend fun getResidents(
//        @Header("Authorization") token: String,
//        @Path("id") id: String
//    ): ResidentsResponse
//
//
    @POST("login")
    suspend fun login(
        @Header("Authorization") token: String,
        @Body details: LoginRequest
    ): LoginResponse

//
}
