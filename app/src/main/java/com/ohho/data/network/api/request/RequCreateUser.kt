package com.ohho.data.network.api.request

import com.google.gson.annotations.SerializedName

data class RequCreateUser(
    @SerializedName("name") val name: String? = "",
    @SerializedName("apartment_name") val apartment_name: String? = "",
    @SerializedName("block_no") val block_no: String? = "",
    @SerializedName("floor_no") val floor_no: String? = "",
    @SerializedName("flat_no") val flat_no: String? = "",
    @SerializedName("street_name") val street_name: String? = "",
    @SerializedName("area") val area: String? = "",
    @SerializedName("landmark") val landmark: String? = "",
    @SerializedName("pincode") val pincode: String? = "",
    @SerializedName("mobileno") val mobileno: String? = ""

)
