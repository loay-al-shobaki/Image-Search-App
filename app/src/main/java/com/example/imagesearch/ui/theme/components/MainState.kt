package com.example.imagesearch.ui.theme.components

import com.example.imagesearch.network.model.Hit

data class MainState(
    val isLoading: Boolean = false,
    val data: List<Hit> = emptyList(),
    val error: String = ""
)
