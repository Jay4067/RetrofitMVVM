package com.learning.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.learning.retrofitmvvm.Repository.PhotoRepository
import com.learning.retrofitmvvm.ViewModels.MainViewModel
import com.learning.retrofitmvvm.ViewModels.MainViewModelFactory
import com.learning.retrofitmvvm.api.PhotoService
import com.learning.retrofitmvvm.api.RetrofitHelper

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val photoService = RetrofitHelper.getInstance().create(PhotoService ::class.java)
        val repository = PhotoRepository(photoService)

        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.photos.observe(this, Observer {
            Log.d("Photossssss",it.toString())
        })
    }
}