package com.example.bdiary.di.modules

import com.example.bdiary.RetrofitEndPoints
import com.example.bdiary.util.customDataSource.AuthenticationRemoteDataSource
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.7:3000/users/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideUserService(retrofit: Retrofit.Builder) : RetrofitEndPoints{
        return retrofit
            .build()
            .create(RetrofitEndPoints::class.java)
    }

    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(service: RetrofitEndPoints) = AuthenticationRemoteDataSource(service)
}