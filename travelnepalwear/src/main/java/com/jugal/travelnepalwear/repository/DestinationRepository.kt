package com.jugal.travelnepal.repository

import com.jugal.travelnepal.api.MyApiRequest
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepalwear.Entity.Destination
import com.jugal.travelnepalwear.response.DestinationResponse
import com.jugal.travelnepalwear.response.ImageResponse
import okhttp3.MultipartBody

class DestinationRepository: MyApiRequest() {
    val DestinationApi = ServiceBuilder.buildService(com.jugal.travelnepal.api.DestinationApi::class.java)

    suspend fun insertDestination(destination: Destination): DestinationResponse {
        return apiRequest {
            DestinationApi.Insert_Destination(ServiceBuilder.token!!, destination)
        }
    }

    suspend fun getDestination(): DestinationResponse {
        return apiRequest {
            DestinationApi.getDestination(ServiceBuilder.token!!)

        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            DestinationApi.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }

    suspend fun addToCart(destination: Destination):ImageResponse{
        return apiRequest {
            DestinationApi.book(ServiceBuilder.token!!,destination)
        }
    }
}


