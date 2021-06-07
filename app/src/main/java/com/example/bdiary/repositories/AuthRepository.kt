    package com.example.bdiary.repositories

import com.example.bdiary.RetrofitEndPoints
import com.example.bdiary.models.User
import com.example.bdiary.models.responseObjects.AuthResponse
import com.example.bdiary.util.Resource
import com.example.bdiary.util.customDataSource.AuthenticationRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class AuthRepository
@Inject
constructor(
       private val remoteDataSource: AuthenticationRemoteDataSource
)
{
    suspend fun register(user: User) : Flow<Resource<AuthResponse>>  = flow {
        emit(Resource.loading(null))
        try {
            val response = remoteDataSource.register(user)
            emit(Resource.success(response.data!!))
        } catch (e: Exception) {
            emit(Resource.error(e.toString(), null))
        }
    }
}
