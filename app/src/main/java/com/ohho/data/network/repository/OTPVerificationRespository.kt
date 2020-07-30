package com.ohho.data.network.repository

import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.RequVerifyMobileNumber
import com.ohho.data.network.api.response.ResponseVerifyMobileNumber
import com.ohho.data.network.api.service.OTPVerificationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private class OTPVerificationRespositoryImpl(private val api : OTPVerificationApi) :
    OTPVerificationRespository {
    override suspend fun getOtpResult(
        requOTPVerificationApi: RequVerifyMobileNumber,
        onSuccess: OnSuccess<ResponseVerifyMobileNumber>,
        onError: OnError<String>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.otpVerification(reqIsOtpVerification = requOTPVerificationApi)
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


interface OTPVerificationRespository {

    suspend fun getOtpResult(
       requVerifyMobileNumber: RequVerifyMobileNumber,
        onSuccess: OnSuccess<ResponseVerifyMobileNumber>,
        onError: OnError<String>
    )

    companion object Factory {
        fun create(api: OTPVerificationApi): OTPVerificationRespository =
            OTPVerificationRespositoryImpl(api)
    }

}