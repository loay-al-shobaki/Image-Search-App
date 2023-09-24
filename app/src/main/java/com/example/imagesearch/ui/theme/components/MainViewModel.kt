package com.example.imagesearch.ui.theme.components

import androidx.compose.runtime.*

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearch.network.model.Hit
import com.example.imagesearch.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    var list by mutableStateOf(MainState())


    fun getImageList(q: String) = viewModelScope.launch {
        list = MainState(isLoading = true)
        val result = mainRepository.getQuereyItems(q)
       try {
           when (result) {
               is Resource.Loading -> {
                   list = MainState(isLoading = true)
               }

               is Resource.Error -> {
                   list= MainState(error = "Something went wrong")
               }

               is Resource.Success -> {
                   result.data?.hits?.let {
                       list = MainState(data = it)
                   }

               }
           }
       }catch (e:Exception){
           list = MainState(error = "Somthing went wrong")
       }
    }

}