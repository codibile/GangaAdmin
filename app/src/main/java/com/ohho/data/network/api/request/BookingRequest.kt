package com.ohho.data.network.api.request

import com.google.gson.annotations.SerializedName

data class BookingRequest(
    @SerializedName("userid") val userid: String? = "",
    @SerializedName("vehicleid") val vehicleid: String? = "",
    @SerializedName("routeid") val routeid: String? = "",
    @SerializedName("route_stop") val route_stop: String? = "",
    @SerializedName("amount") val amount: String? = ""

)
