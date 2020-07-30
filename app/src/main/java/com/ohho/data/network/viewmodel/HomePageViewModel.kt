/*
 * *
 *  * Created by Nethaji on 27/6/20 1:32 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 27/6/20 1:32 PM
 *
 */

package com.ohho.data.network.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.*
import com.ohho.data.network.api.response.*
import com.ohho.data.network.repository.HomePageRespository
import com.ohho.data.network.repository.MobileNumberValidationRespository
import com.ohho.data.network.repository.OTPVerificationRespository

import kotlinx.coroutines.launch

class HomePageViewModel(
    private val repository: HomePageRespository,
    val context: Context
) : ViewModel() {

    fun getAvailableVehicle(

        onSuccess: OnSuccess<HomePageResponse>,
        onError: OnError<String>
    ) {
        viewModelScope.launch {
            repository.getHomePageResult(
                onSuccess, onError
            )
        }
    }


    fun getRouteDetails(
        requRouteDetails: RequRouteDetails,
        onSuccess: OnSuccess<RouteResponse>,
        onError: OnError<String>
    ) {
        viewModelScope.launch {
            repository.getRouteDetails(
                requRouteDetails,
                onSuccess, onError
            )
        }
    }


    fun BookaNewTrip(
      bookingRequest: BookingRequest,
        onSuccess: OnSuccess<BookingResponse>,
        onError: OnError<String>
    ) {
        println("testing_hi"+"jwsbdkjasjknasjk" + "3")
        viewModelScope.launch {
            repository.BookaNewTrip(
                bookingRequest,
                onSuccess, onError
            )
        }
    }
}