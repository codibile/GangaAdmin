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
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.request.RequUpComing
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import com.ohho.data.network.api.response.UpcomingResponse
import com.ohho.data.network.repository.MobileNumberValidationRespository
import com.ohho.data.network.repository.UpcomingRespository

import kotlinx.coroutines.launch

class UpcomingListViewModel(
    private val repository: UpcomingRespository,
    val context: Context
) : ViewModel() {

    fun getUpcomingList(
            requUpComing: RequUpComing,
            onSuccess: OnSuccess<UpcomingResponse>,
            onError: OnError<String>
    ) {
        viewModelScope.launch {
            repository.getUpcomingBookingList(
                requUpComing,onSuccess, onError)
        }
    }

}