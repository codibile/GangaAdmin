package com.ohho.data.network.repository

import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.BookingRequest
import com.ohho.data.network.api.request.RequBook
import com.ohho.data.network.api.request.RequRouteDetails
import com.ohho.data.network.api.request.RequVerifyMobileNumber
import com.ohho.data.network.api.response.BookingResponse
import com.ohho.data.network.api.response.HomePageResponse
import com.ohho.data.network.api.response.ResponseVerifyMobileNumber
import com.ohho.data.network.api.response.RouteResponse
import com.ohho.data.network.api.service.HomePageApi
import com.ohho.data.network.api.service.OTPVerificationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private class HomePageRespositoryImpl(private val api : HomePageApi) :
    HomePageRespository {
    override suspend fun getHomePageResult(

        onSuccess: OnSuccess<HomePageResponse>,
        onError: OnError<String>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.vehicleDetails()
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

    override suspend fun getRouteDetails(
        requRouteDetails: RequRouteDetails,
        onSuccess: OnSuccess<RouteResponse>,
        onError: OnError<String>
    ) {


        withContext(Dispatchers.IO) {
            try {
                val response = api.getRouteDetails(requRouteDetails = requRouteDetails)
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

    override suspend fun BookaNewTrip(
        bookingRequest: BookingRequest,
        onSuccess: OnSuccess<BookingResponse>,
        onError: OnError<String>
    ) {



        withContext(Dispatchers.IO) {
            try {
                val response = api.BookaSeat(bookingRequest = bookingRequest)
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


interface HomePageRespository {

    suspend fun getHomePageResult(
        onSuccess: OnSuccess<HomePageResponse>,
        onError: OnError<String>
    )

    suspend fun getRouteDetails(
requRouteDetails: RequRouteDetails,
        onSuccess: OnSuccess<RouteResponse>,
        onError: OnError<String>
    )

    suspend fun BookaNewTrip(
      bookingRequest: BookingRequest,
        onSuccess: OnSuccess<BookingResponse>,
        onError: OnError<String>
    )

    companion object Factory {
        fun create(api: HomePageApi): HomePageRespository =
            HomePageRespositoryImpl(api)
    }

}