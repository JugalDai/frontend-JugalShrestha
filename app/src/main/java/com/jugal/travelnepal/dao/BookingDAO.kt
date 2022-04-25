package com.jugal.travelnepal.dao

import androidx.room.Query
import com.jugal.travelnepal.entity.Booking

interface BookingDAO {
    @Query("select* from booking")
    suspend fun  getBooking() : MutableList<Booking>
}