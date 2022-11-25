package com.learning.retrofitmvvm.api

import com.learning.retrofitmvvm.Model.ResponseItem
import com.learning.retrofitmvvm.Model.ResponsePhotos
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    suspend fun getPhotos() : Response<List<ResponseItem>>

}