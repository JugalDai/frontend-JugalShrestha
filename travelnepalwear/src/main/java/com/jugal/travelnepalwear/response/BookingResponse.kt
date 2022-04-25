package com.jugal.travelnepalwear.response

import com.jugal.travelnepal.entity.Booking

data class BookingResponse (
    val success: Boolean? =null,
    val data : MutableList<Booking>? = null
    )