package com.sebas.santiagocompose.di

import androidx.compose.ui.geometry.Rect
import com.google.gson.GsonBuilder
import com.sebas.santiagocompose.repository.FetchCharactersRepository
import com.sebas.santiagocompose.repository.network.JsonPlaceHolderApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {


    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(
        retrofit: Retrofit
    ): JsonPlaceHolderApiService {
        return retrofit.create(JsonPlaceHolderApiService::class.java)
    }

}