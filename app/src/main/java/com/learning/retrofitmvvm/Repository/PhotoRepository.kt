package com.learning.retrofitmvvm.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learning.retrofitmvvm.Model.ResponseItem
import com.learning.retrofitmvvm.Model.ResponsePhotos
import retrofit2.Callback
import com.learning.retrofitmvvm.api.PhotoService

class PhotoRepository(private val photoService: PhotoService) {

    private val photoLiveData = MutableLiveData<List<ResponseItem>>()

    val photos: LiveData<List<ResponseItem>>
    get() = photoLiveData

    suspend fun getPhotos(){
        val result = photoService.getPhotos()

        if(result?.body() !=null){
            photoLiveData.postValue(result.body())
        }
    }
}