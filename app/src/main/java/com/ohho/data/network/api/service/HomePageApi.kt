package com.ohho.data.network.api.service

import com.ohho.data.network.api.request.BookingRequest
import com.ohho.data.network.api.request.RequBook
import com.ohho.data.network.api.request.RequRouteDetails
import com.ohho.data.network.api.request.RequVerifyMobileNumber
import com.ohho.data.network.api.response.BookingResponse
import com.ohho.data.network.api.response.HomePageResponse
import com.ohho.data.network.api.response.ResponseVerifyMobileNumber
import com.ohho.data.network.api.response.RouteResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomePageApi {

    @GET("available_vehicle.php")
    suspend fun vehicleDetails(): Response<HomePageResponse>


    @POST("route_details.php")
    suspend fun getRouteDetails(

        @Body requRouteDetails: RequRouteDetails
    ): Response<RouteResponse>



    @POST("booking_confirm.php")
    suspend fun BookaSeat(
        @Body bookingRequest: BookingRequest
    ): Response<BookingResponse>
}