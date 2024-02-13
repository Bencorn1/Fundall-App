package com.ayotola.fundall_app.viewmodel

import com.ayotola.fundall_app.utils.BaseVM
import com.ayotola.fundall_app.CreateUserRequest
import com.ayotola.fundall_app.CreateUserResponse
import com.ayotola.fundall_app.repository.CreateRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class CreateUserViewModel @Inject constructor(private val repo: CreateRepo
) : BaseVM<Response<CreateUserResponse>>() {

    fun createUser(token: String, request: CreateUserRequest) {
        loadData {
            repo.createUser(token = token, request = request)
        }
    }

}


