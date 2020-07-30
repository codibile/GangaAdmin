package com.ohho.data.network.repository

import com.mlm.recharege.di.OnError
import com.mlm.recharege.di.OnSuccess
import com.ohho.data.network.api.request.RequMobileNumberValidation
import com.ohho.data.network.api.request.RequUpComing
import com.ohho.data.network.api.response.ResponseMobileNumberValidation
import com.ohho.data.network.api.response.UpcomingResponse
import com.ohho.data.network.api.service.UpcomingPageApi
import com.ohho.data.network.api.service.UserMobileNumberValidationApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

private class UpcomingRespositoryImpl(private val api : UpcomingPageApi) :
    UpcomingRespository {
    override suspend fun getUpcomingBookingList(
       requUpComing: RequUpComing,
        onSuccess: OnSuccess<UpcomingResponse>,
        onError: OnError<String>
    ) {
        withContext(Dispatchers.IO) {
            try {
                val response = api.upcoming(requUpComing = requUpComing)
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


interface UpcomingRespository {

    suspend fun getUpcomingBookingList(
      requUpComing: RequUpComing,
        onSuccess: OnSuccess<UpcomingResponse>,
        onError: OnError<String>
    )

    companion object Factory {
        fun create(api: UpcomingPageApi): UpcomingRespository =
            UpcomingRespositoryImpl(api)
    }

}