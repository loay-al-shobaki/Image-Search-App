package com.example.imagesearch.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loding<T>() : Resource<T>()
    class Error<T>(message: String?) : Resource<T>(message = message)
    class Success<T>(data: T?) : Resource<T>(data = data)
}
