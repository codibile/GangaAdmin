package com.ohho.data.network.api.response

data class HomePageResponse(
    val msg: String,
    val res: List<Re>,
    val status: String
) {
    data class Re(
        val carid: Int,
        val `class`: String,
        val end_place: String,
        val start_place: String,
        val status: String,
        val type: String
    )
}