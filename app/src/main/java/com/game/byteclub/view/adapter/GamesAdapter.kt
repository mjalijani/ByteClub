package com.game.byteclub.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.databinding.GamesItemBinding

class GamesAdapter(private val gamesList: MutableList<String>) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    //todo : implement click lister to present new fragment
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : GamesItemBinding = GamesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameNameTv.text = gamesList[position]
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    class ViewHolder(binding : GamesItemBinding) : RecyclerView.ViewHolder(binding.root){

         var gameNameTv : TextView

        init {
            gameNameTv = binding.name
        }

    }

}