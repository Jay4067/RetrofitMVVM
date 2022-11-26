package com.learning.retrofitmvvm.Adapter

import android.app.Activity
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learning.retrofitmvvm.Model.ResponseItem
import com.learning.retrofitmvvm.R

class PhotoListAdapter(val activity: Activity ) : RecyclerView.Adapter<PhotoListAdapter.MyViewHolder>(){

    private var photoList : List<ResponseItem>?=null

    fun setPhotoList(photoList : List<ResponseItem>?){
        this.photoList= photoList!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    holder.bind(photoList?.get(position)!!,activity)

    }

    override fun getItemCount(): Int {
        if(photoList==null) return  0
        else return photoList?.size!!
    }


    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        val imageView: ImageView = view.findViewById(R.id.imageView)
        val textView: TextView = view.findViewById(R.id.main_heading)

        fun bind(data : ResponseItem,activity: Activity){
            textView.text = data.title+"()"
            Glide.with(activity).load(data.url)
                .placeholder(R.drawable.ic_launcher_background)
                .override(200,200)
                .centerCrop()
                .into(imageView)
        }



    }

}