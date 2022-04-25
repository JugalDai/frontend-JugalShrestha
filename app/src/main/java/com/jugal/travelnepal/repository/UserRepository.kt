package com.jugal.travelnepal.repository

import com.jugal.travelnepal.api.MyApi
import com.jugal.travelnepal.api.MyApiRequest
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepal.entity.User
import com.jugal.travelnepal.response.ImageResponse
import com.jugal.travelnepal.response.LoginResponse
import okhttp3.MultipartBody

class UserRepository: MyApiRequest() {
    val myApi = ServiceBuilder.buildService(MyApi::class.java)

    suspend fun registerUser(user: User): LoginResponse{
        return apiRequest {
            myApi.registerUser(user)
        }
    }

    suspend fun checkUser(username : String, password: String): LoginResponse{
        return apiRequest {
            myApi.checkUser(username, password)
        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : ImageResponse {
        return apiRequest {
            myApi.uploadImage( id, body)
        }
    }
}