package com.learning.retrofitmvvm.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.retrofitmvvm.Model.ResponseItem
import com.learning.retrofitmvvm.Model.ResponsePhotos
import com.learning.retrofitmvvm.Repository.PhotoRepository
import com.learning.retrofitmvvm.api.PhotoService
import com.learning.retrofitmvvm.api.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: PhotoRepository) : ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getPhotos()
        }
    }

    val photos : LiveData<List<ResponseItem>>
    get() = repository.photos

//    fun makeAPICall(){
//        val retrofitHelper = RetrofitHelper.getInstance()
//        val photoService = retrofitHelper.create(PhotoService::class.java)
//        val call = photoService.getPhotos()
//    }
}