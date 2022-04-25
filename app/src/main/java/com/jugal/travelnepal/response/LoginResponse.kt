package com.jugal.travelnepal.response

import com.jugal.travelnepal.entity.User

data class LoginResponse (
        val success : Boolean? = null,
        val token : String? = null,
        val data : User? = null
)