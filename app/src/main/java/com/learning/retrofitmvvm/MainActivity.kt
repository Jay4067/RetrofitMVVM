package com.learning.retrofitmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lea.MainViewModel
import com.learning.retrofitmvvm.Model.ResponseItem

import com.learning.retrofitmvvm.databinding.ActivityMainBinding
import com.learning.retrofitmvvm.Adapter.PhotoListAdapter as PhotoListAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    lateinit var recyclerAdapter : PhotoListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initRecyclerView()
        initViewModel()

    }

    private fun initRecyclerView(){

//        val recyclerAdapter=PhotoListAdapter(this)

        binding.rvPhotos.layoutManager = LinearLayoutManager(this)

        recyclerAdapter = PhotoListAdapter(this)
        binding.rvPhotos.adapter = recyclerAdapter

    }

    private fun initViewModel(){


        val viewModel : MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getliveDataObserver().observe(this,Observer{
            if(it!=null){
               recyclerAdapter.setPhotoList(it)
                recyclerAdapter.notifyDataSetChanged()
            }
            else{
                Toast.makeText(this,"Error in getting list",Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }

}