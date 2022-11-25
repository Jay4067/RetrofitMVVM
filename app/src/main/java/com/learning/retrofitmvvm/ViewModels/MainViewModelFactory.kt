package com.learning.retrofitmvvm.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learning.retrofitmvvm.Repository.PhotoRepository

class MainViewModelFactory (private val repository: PhotoRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}