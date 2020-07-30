package com.ohho.data.network.api.service

import com.mespace.di.utility.API
import com.ohho.data.network.api.request.RequCreateUser
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.response.RegisterPageResponse
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface UserRegisterApi {

    @POST("register.php")
    suspend fun getUserRegister(

        @Body requCreateUser: RequCreateUser
    ): Response<RegisterPageResponse>
}