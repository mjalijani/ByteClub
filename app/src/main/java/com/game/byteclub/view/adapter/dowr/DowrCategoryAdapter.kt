package com.game.byteclub.view.adapter.dowr

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.BuildConfig
import com.game.byteclub.databinding.DowrCategoryItemBinding

class DowrCategoryAdapter : RecyclerView.Adapter<DowrCategoryAdapter.ViewHolder>() {


    private var categoryList = mutableListOf<String>()

    init {
        if (BuildConfig.DEBUG){
            categoryList.add("Sport")
            categoryList.add("Food")
            categoryList.add("Names")
            categoryList.add("Location")
            categoryList.add("Job")
            categoryList.add("Technology")
            categoryList.add("Drinks")
            categoryList.add("Cars")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DowrCategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.text = categoryList[position]
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


    class ViewHolder(binding : DowrCategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var nameTv : TextView

        init {
            nameTv = binding.categoryNameTv
        }

    }




}