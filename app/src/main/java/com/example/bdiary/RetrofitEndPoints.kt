package com.example.bdiary

import com.example.bdiary.models.User
import com.example.bdiary.models.responseObjects.AuthResponse
import dagger.hilt.internal.GeneratedEntryPoint
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.*

interface RetrofitEndPoints {
    @POST("register")
    suspend fun register(@Body user: User): retrofit2.Response<AuthResponse>

    @POST("login")
    suspend fun login(@Body user: User): retrofit2.Response<AuthResponse>

    @GET("")
    suspend fun getUsers(): List<User>
}