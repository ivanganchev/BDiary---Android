package com.example.bdiary.di.modules

import com.example.bdiary.RetrofitEndPoints
import com.example.bdiary.repositories.AuthRepository
import com.example.bdiary.util.customDataSource.AuthenticationRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepo(
            remoteDataSource: AuthenticationRemoteDataSource
    ): AuthRepository {
        return AuthRepository(remoteDataSource)
    }
}