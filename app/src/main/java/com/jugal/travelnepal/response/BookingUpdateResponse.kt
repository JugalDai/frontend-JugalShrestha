package com.jugal.travelnepal.response

import com.jugal.travelnepal.entity.Booking

data class BookingUpdateResponse (
    val success: Boolean? =null,
    val data : Booking? = null
    )