package com.ayotola.fundall_app

data class CreateUserRequest(
    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
    val password_confirmation: String,
)

data class LoginRequest(
    val email: String,
    val password: String,
)



