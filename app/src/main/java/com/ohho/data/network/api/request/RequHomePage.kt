package com.ohho.data.network.api.request

import com.google.gson.annotations.SerializedName

data class RequHomePage(
    @SerializedName("mobileno") val phone: String? = "",
    @SerializedName("otp") val otp: String? = ""
)
