package com.ayotola.fundall_app

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


