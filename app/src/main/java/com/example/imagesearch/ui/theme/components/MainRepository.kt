package com.example.imagesearch.ui.theme.components

import com.example.imagesearch.network.model.ApiService
import com.example.imagesearch.network.model.PixabayResponse
import com.example.imagesearch.util.Resource
import java.lang.Exception
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getQuereyItems(q: String): Resource<PixabayResponse> {
        return try {
            val result = apiService.gerQueryImage(query = q)
            Resource.Success(data = result)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}