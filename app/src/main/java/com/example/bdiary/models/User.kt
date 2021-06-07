package com.example.bdiary.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User (
        @SerializedName("username")
        @Expose
        var username: String,
        @SerializedName("password")
        @Expose
        var password: String,
        @SerializedName("email")
        @Expose
        var email: String
        ){
}