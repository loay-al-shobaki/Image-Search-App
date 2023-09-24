package com.example.imagesearch.network.model

import com.example.imagesearch.util.Constant.KEY_API
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun gerQueryImage(
        @Query("q") query: String,
        @Query("key") key: String =KEY_API,
        @Query("image_type") imageType: String = "photo"
    ):PixabayResponse

}