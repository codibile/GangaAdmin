package com.ohho.data.network.api.service

import com.ohho.data.network.api.request.RequVerifyMobileNumber
import com.ohho.data.network.api.response.ResponseVerifyMobileNumber
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface OTPVerificationApi {

    @POST("otp_validate.php")
    suspend fun otpVerification(

        @Body reqIsOtpVerification: RequVerifyMobileNumber
    ): Response<ResponseVerifyMobileNumber>
}