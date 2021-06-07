package com.example.bdiary.models.responseObjects

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class AuthResponse(
    @SerializedName("token")
    @Expose
    val token: String,
    @SerializedName("info")
    @Expose
    val info: String
    )