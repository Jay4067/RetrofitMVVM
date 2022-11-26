package com.lea

import android.util.Log
import javax.security.auth.callback.Callback



import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learning.retrofitmvvm.Model.ResponseItem
import com.learning.retrofitmvvm.api.PhotoService
import com.learning.retrofitmvvm.api.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class MainViewModel : ViewModel() {

    lateinit var liveDatalist: MutableLiveData<List<ResponseItem>>


    init {
            liveDatalist = MutableLiveData()
        }

    fun getliveDataObserver(): MutableLiveData<List<ResponseItem>> {
        return liveDatalist
    }

    fun makeAPICall(){
        val retroInstance = RetrofitInstance.getRetrofitInstance()
        val retroService = retroInstance.create(PhotoService::class.java)
        val call = retroService.getPhotos()
        call.enqueue(object :retrofit2.Callback<List<ResponseItem>>{
            override fun onResponse(
                call: Call<List<ResponseItem>>,
                response: Response<List<ResponseItem>>
            ) {
                liveDatalist.postValue(response.body())
            }

            override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                Log.d("Somehting wrongggg",t.localizedMessage.toString())
            }
        })

    }

    }




