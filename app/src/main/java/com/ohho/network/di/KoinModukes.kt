/*
 * *
 *  * Created by Nethaji on 27/6/20 1:18 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 27/6/20 1:13 PM
 *
 */

package com.mlm.recharege.di



import org.koin.dsl.module


/**
 * Networking modules here
 * Must be a singleton
 * Also, using the default overload methods
 **/
val NETWORKING_MODULE = module {
  /* single { HttpClientManager.newInstance(androidContext()) }
      single { get<HttpClientManager>().createApi<LoginApi>() }
   single { get<HttpClientManager>().createApi<MobileRechargeApi>() }*/


}

/**
 * Repository modules here
 * Must be a singleton
 **/
val REPOSITORY_MODULE = module {
   /* single { ProfileRepository.create(get()) }
   single { RechargeOptionRepository.create(get()) }*/

}

/**
 * ViewModel modules here
 **/
val VIEW_MODEL_MODULE = module {
   /* viewModel { ProfileViewModel(get(), androidContext()) }
   viewModel { RechargeOptionViewModel(get(), androidContext()) }*/


}

