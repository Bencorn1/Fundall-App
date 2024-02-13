package com.ayotola.fundall_app.viewmodel

import com.ayotola.fundall_app.utils.BaseVM
import com.ayotola.fundall_app.LoginRequest
import com.ayotola.fundall_app.LoginResponse
import com.ayotola.fundall_app.repository.LoginRepo
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
