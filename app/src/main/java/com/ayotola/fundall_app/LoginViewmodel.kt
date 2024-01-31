package com.ayotola.fundall_app

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewmodel @Inject constructor( private val loginRepository: LoginRepo): BaseVM<LoginResponse>() {

    fun login(token: String, request: LoginRequest) {
        loadData {
            loginRepository.loginUser(token = token, request = request)
        }
    }

}
