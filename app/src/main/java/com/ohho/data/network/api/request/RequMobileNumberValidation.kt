package com.ohho.data.network.api.request

import com.google.gson.annotations.SerializedName

data class RequMobileNumberValidation (    @SerializedName("mobileno") val phone: String? = ""
)
