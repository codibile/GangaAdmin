/*
 * *
 *  * Created by Nethaji on 27/6/20 1:18 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 27/6/20 1:13 PM
 *
 */

package com.mlm.recharege.di


import com.mlm.recharege.network.http.HttpClientManager
import com.mlm.recharege.network.http.createApi
import com.ohho.data.network.api.service.*
import com.ohho.data.network.repository.*
import com.ohho.data.network.viewmodel.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


/**
 * Networking modules here
 * Must be a singleton
 * Also, using the default overload methods
 **/
val NETWORKING_MODULE = module {
    single { HttpClientManager.newInstance(androidContext()) }
    single { get<HttpClientManager>().createApi<UserMobileNumberValidationApi>() }
    single { get<HttpClientManager>().createApi<OTPVerificationApi>() }
    single { get<HttpClientManager>().createApi<HomePageApi>() }
    single { get<HttpClientManager>().createApi<UserRegisterApi>() }
    single { get<HttpClientManager>().createApi<UpcomingPageApi>() }


}

/**
 * Repository modules here
 * Must be a singleton
 **/
val REPOSITORY_MODULE = module {
    single { MobileNumberValidationRespository.create(get()) }
    single { OTPVerificationRespository.create(get()) }
    single { HomePageRespository.create(get()) }
    single { RegisterUserRespository.create(get()) }
    single { UpcomingRespository.create(get()) }


}

/**
 * ViewModel modules here
 **/
val VIEW_MODEL_MODULE = module {
    viewModel { MobileNumberValidationViewModel(get(), androidContext()) }
    viewModel { OtpVerificationViewModel(get(), androidContext()) }
    viewModel { HomePageViewModel(get(), androidContext()) }
    viewModel { RegisterUserViewModel(get(), androidContext()) }
    viewModel { UpcomingListViewModel(get(), androidContext()) }



}

