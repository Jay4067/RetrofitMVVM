package com.learning.retrofitmvvm.api

import com.learning.retrofitmvvm.Model.ResponseItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
     fun getPhotos() : Call<List<ResponseItem>>

}