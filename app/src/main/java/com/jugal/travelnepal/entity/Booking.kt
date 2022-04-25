package com.jugal.travelnepal.entity

//@Entity
data class Booking (
//        @PrimaryKey
        val _id : String?= null,
        val UserId: String? =null,
        val Destination: Destination? = null,
        var Person: Int? = 0,
        val Date : String? = null
        )