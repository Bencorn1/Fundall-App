package com.ayotola.fundall_app

import com.google.gson.annotations.SerializedName

data class CreateUserResponse(
    @SerializedName("success") var success: Success? = Success()
)

data class Success(

    @SerializedName("message") var message: String? = null,
    @SerializedName("status") var status: String? = null

)


data class LoginResponse(

    @SerializedName("success") var success: LoginSuccess? = LoginSuccess()

)

data class User(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("firstname") var firstname: String? = null,
    @SerializedName("lastname") var lastname: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("avatar") var avatar: String? = null,
    @SerializedName("monthly_target") var monthlyTarget: Int? = null,
    @SerializedName("created_at") var createdAt: String? = null,
    @SerializedName("updated_at") var updatedAt: String? = null,
    @SerializedName("access_token") var accessToken: String? = null,
    @SerializedName("token_type") var tokenType: String? = null,
    @SerializedName("expires_at") var expiresAt: String? = null

)

data class LoginSuccess(

    @SerializedName("user") var user: User? = User(),
    @SerializedName("status") var status: String? = null

)