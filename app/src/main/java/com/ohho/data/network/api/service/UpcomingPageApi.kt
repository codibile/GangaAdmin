package com.ohho.data.network.api.service

import com.ohho.data.network.api.request.*
import com.ohho.data.network.api.response.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UpcomingPageApi {


    @POST("my_booking.php")
    suspend fun upcoming(
        @Body requUpComing: RequUpComing
    ): Response<UpcomingResponse>
}