package com.ohho.data.network.api.service

import com.mespace.di.utility.API
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface UserMobileNumberValidationApi {

    @POST("login.php")
    suspend fun getUserLogin(

        @Body reqIsMobileNumberValidation: RequMobileNumberValidation
    ): Response<ResponseMobileNumberValidation>
}