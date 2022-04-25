package com.jugal.travelnepal.repository

import com.jugal.travelnepal.Personnn
import com.jugal.travelnepal.api.BookingApi
import com.jugal.travelnepal.api.MyApiRequest
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepal.response.BookingResponse
import com.jugal.travelnepal.response.BookingUpdateResponse

class BookingRepository: MyApiRequest() {
    val BookingApi = ServiceBuilder.buildService(BookingApi::class.java)

    suspend fun getBooking(): BookingResponse{
        return apiRequest {
            BookingApi.getBooking(ServiceBuilder.token!!)
        }
    }

    suspend fun deleteBooking(id: String): BookingResponse{
        return apiRequest {
            BookingApi.deleteBooking(ServiceBuilder.token!!, id)
        }
    }

    suspend fun updateBooking(id: String, Person: Personnn) : BookingUpdateResponse{

        return apiRequest {
//            BookingApi.updateBooking(Person = Person, id = id, token = ServiceBuilder.token!!)
            BookingApi.updateBooking(ServiceBuilder.token!!, id, Person)

        }
    }
}