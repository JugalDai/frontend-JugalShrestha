package com.jugal.travelnepal.api

import com.jugal.travelnepal.entity.User
import com.jugal.travelnepal.response.ImageResponse
import com.jugal.travelnepal.response.LoginResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface MyApi {
    //Register User
    @POST("/register")
    suspend fun registerUser(@Body user: User): Response<LoginResponse>

    @FormUrlEncoded
    @POST("/login")
    suspend fun checkUser(
            @Field("username") username : String,
            @Field("password") password :String,
    ): Response<LoginResponse>

    @Multipart
    @PUT("/photo/{id}")
    suspend fun uploadImage(
            @Path("id") id: String,
            @Part file: MultipartBody.Part
    ): Response<ImageResponse>

}