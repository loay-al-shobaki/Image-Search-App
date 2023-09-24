package com.example.imagesearch.di

import com.example.imagesearch.network.model.ApiService
import com.example.imagesearch.ui.theme.components.MainRepository
import com.example.imagesearch.ui.theme.components.MainViewModel
import com.example.imagesearch.util.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainRepository(api: ApiService): MainRepository {
        return MainRepository(apiService = api)
    }


}