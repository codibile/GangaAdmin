package com.ohho.data.network.api.response

data class UpcomingResponse(
    val msg: String,
    val res: List<Re>,
    val status: String
) {
    data class Re(
        val driver_mobile: Long,
        val driver_name: String,
        val drop_place: String,
        val end_place: String,
        val id: Int,
        val start_place: String,
        val status: String,
        val type: String
    )
}