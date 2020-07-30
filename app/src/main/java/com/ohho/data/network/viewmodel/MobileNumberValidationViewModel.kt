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
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import com.ohho.data.network.repository.MobileNumberValidationRespository

import kotlinx.coroutines.launch

class MobileNumberValidationViewModel(
    private val repository: MobileNumberValidationRespository,
    val context: Context
) : ViewModel() {

    fun getHomePageList(
            reqUpdateUser: RequMobileNumberValidation,
            onSuccess: OnSuccess<ResponseMobileNumberValidation>,
            onError: OnError<String>
    ) {
        viewModelScope.launch {
            repository.getHomePageList(
                    reqUpdateUser,onSuccess, onError)
        }
    }

}