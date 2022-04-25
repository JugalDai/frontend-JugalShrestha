package com.jugal.travelnepalwear.repository

import com.jugal.travelnepal.api.MyApi
import com.jugal.travelnepal.api.MyApiRequest
import com.jugal.travelnepal.api.ServiceBuilder
import com.jugal.travelnepalwear.response.LoginResponse

class UserRepository: MyApiRequest(){
    val myApi = ServiceBuilder.buildService(MyApi::class.java)

//    suspend fun registerUser(user: User): LoginResponse {
//        return apiRequest {
//            myApi.registerUser(user)
//        }
//    }

    suspend fun checkUser(username : String, password: String): LoginResponse{
        return apiRequest {
            myApi.checkUser(username, password)
        }
    }
}