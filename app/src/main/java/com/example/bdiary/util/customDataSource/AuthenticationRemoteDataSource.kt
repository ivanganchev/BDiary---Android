package com.example.bdiary.util.customDataSource

import com.example.bdiary.RetrofitEndPoints
import com.example.bdiary.models.User
import com.example.bdiary.util.BaseDataSource
import javax.inject.Inject

class AuthenticationRemoteDataSource @Inject constructor(
        private val authService: RetrofitEndPoints
): BaseDataSource() {
    suspend fun login(user: User) = getResult { authService.login(user) }
    suspend fun register(user: User) = getResult { authService.register(user) }
}