package com.jugal.travelnepal.response

import com.jugal.travelnepal.entity.Destination

data class DestinationResponse (
    val success : Boolean? = null,
    val data : MutableList<Destination>? = null
    )