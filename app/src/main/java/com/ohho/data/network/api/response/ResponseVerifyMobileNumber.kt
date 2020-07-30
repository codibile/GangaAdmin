package com.ohho.data.network.api.response

data class ResponseVerifyMobileNumber(
    val msg: String,
    val name: String,
    val redirect: String,
    val status: String,
    val userid: String
)