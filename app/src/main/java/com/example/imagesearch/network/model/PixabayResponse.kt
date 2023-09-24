package com.example.imagesearch.network

data class PixabayResponse(
    val hits: List<Hit>,
    val total: Int,
    val totalHits: Int
)