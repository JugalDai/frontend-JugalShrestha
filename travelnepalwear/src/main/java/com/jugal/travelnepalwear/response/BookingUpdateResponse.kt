package com.jugal.travelnepalwear.response

import com.jugal.travelnepal.entity.Booking

data class BookingUpdateResponse (
    val success: Boolean? =null,
    val data : Booking? = null
    )