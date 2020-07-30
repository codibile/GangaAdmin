package com.ohho.data.network.api.response

data class RouteResponse(
    val msg: String,
    val res: List<Re>,
    val ride_later: List<RideLater>,
    val seat_available: Int,
    val trip_route: Int,
    val status: String
) {
    data class Re(
        val amount: Int,
        val id: Int,
        val location: String
    )

    data class RideLater(
        val amount: Int,
        val id: Int,
        val location: String
    )
}