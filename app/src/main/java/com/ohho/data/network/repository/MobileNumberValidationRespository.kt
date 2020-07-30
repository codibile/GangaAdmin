package com.ohho.data.network.repository

import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import com.ohho.data.network.api.service.UserMobileNumberValidationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private class MobileNumberValidationRespositoryImpl(private val api : UserMobileNumberValidationApi) :
    MobileNumberValidationRespository {
    override suspend fun getHomePageList(
        reqIsMobileNumberValidation: RequMobileNumberValidation,
        onSuccess: OnSuccess<ResponseMobileNumberValidation>,
        onError: OnError<String>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.getUserLogin(reqIsMobileNumberValidation = reqIsMobileNumberValidation)
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


interface MobileNumberValidationRespository {

    suspend fun getHomePageList(
        requMobileNumberValidation: RequMobileNumberValidation,
        onSuccess: OnSuccess<ResponseMobileNumberValidation>,
        onError: OnError<String>
    )

    companion object Factory {
        fun create(api: UserMobileNumberValidationApi): MobileNumberValidationRespository =
            MobileNumberValidationRespositoryImpl(api)
    }

}