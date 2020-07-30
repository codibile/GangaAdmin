package com.ohho.data.network.repository

import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.RequCreateUser
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.response.RegisterPageResponse
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import com.ohho.data.network.api.service.UserMobileNumberValidationApi
import com.ohho.data.network.api.service.UserRegisterApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private class RegisterUserRespositoryImpl(private val api : UserRegisterApi) :
    RegisterUserRespository {
    override suspend fun getRegisterResponse(
        requCreateUser: RequCreateUser,
        onSuccess: OnSuccess<RegisterPageResponse>,
        onError: OnError<String>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.getUserRegister(requCreateUser = requCreateUser)
                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.status.equals("success"))
                            withContext(Dispatchers.Main) { onSuccess(it) }
                        else
                            withContext(Dispatchers.Main) { onError(it.msg) }
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        onError(response.message().toString())
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {}
            }
        }

    }


}


interface RegisterUserRespository {

    suspend fun getRegisterResponse(
        requCreateUser: RequCreateUser,
        onSuccess: OnSuccess<RegisterPageResponse>,
        onError: OnError<String>
    )

    companion object Factory {
        fun create(api: UserRegisterApi): RegisterUserRespository =
            RegisterUserRespositoryImpl(api)
    }

}