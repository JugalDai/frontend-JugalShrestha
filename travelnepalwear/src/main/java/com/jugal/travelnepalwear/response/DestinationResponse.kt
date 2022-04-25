package com.jugal.travelnepalwear.response

import com.jugal.travelnepalwear.Entity.Destination

data class DestinationResponse (
    val success : Boolean? = null,
    val data : MutableList<Destination>? = null
    )