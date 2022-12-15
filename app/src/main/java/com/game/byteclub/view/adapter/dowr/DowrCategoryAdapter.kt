package com.game.byteclub.view.adapter.dowr

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.BuildConfig
import com.game.byteclub.R
import com.game.byteclub.databinding.DowrCategoryItemBinding
import com.game.byteclub.model.dowr.Category

class DowrCategoryAdapter : RecyclerView.Adapter<DowrCategoryAdapter.ViewHolder>() {


    var categoryList = mutableListOf<Category>()

    init {
        if (BuildConfig.DEBUG) {
            generateTestData()
        }
    }

    private fun generateTestData() {
        categoryList.add(Category("Sport", true))
        categoryList.add(Category("Food", true))
        categoryList.add(Category("Names", true))
        categoryList.add(Category("Location", true))
        categoryList.add(Category("Job", true))
        categoryList.add(Category("Technology", true))
        categoryList.add(Category("Drinks", true))
        categoryList.add(Category("Cars", true))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            DowrCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = ViewHolder(binding)
        holder.itemView.setOnClickListener {
            categoryList[holder.adapterPosition].select()
            notifyItemChanged(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameTv.text = categoryList[position].name
        holder.updateView(categoryList[position].selected)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


    class ViewHolder(val binding: DowrCategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {

        var nameTv: TextView = binding.categoryNameTv

        fun updateView(selected: Boolean) {
            if (selected) {
                binding.categoryFl.setBackgroundDrawable(
                    binding.root.context.resources.getDrawable(
                        R.drawable.bg_rectangle_primary_rounded
                    )
                )
                nameTv.setTextColor(binding.root.context.resources.getColor(R.color.secondary))
            } else {
                binding.categoryFl.setBackgroundDrawable(
                    binding.root.context.resources.getDrawable(
                        R.drawable.bg_rectangle_light_primary_roundted
                    )
                )
                nameTv.setTextColor(binding.root.context.resources.getColor(R.color.primary_dark))
            }
        }

    }


}