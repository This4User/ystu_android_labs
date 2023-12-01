package com.example.ystu.service

import com.example.ystu.dto.UserDTO
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getUsers(): List<UserDTO>
}