package com.jugal.travelnepal.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jugal.travelnepalwear.Entity.Destination

@Entity
data class Booking (
        @PrimaryKey
        val _id : String= "",
        val UserId: String? =null,
        val Destination: Destination? = null,
        var Person: Int? = 0,
        val Date : String? = null
        )