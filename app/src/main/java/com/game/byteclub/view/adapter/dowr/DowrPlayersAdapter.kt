package com.game.byteclub.view.adapter.dowr

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.BuildConfig
import com.game.byteclub.databinding.DowrAddPlayerBinding
import com.game.byteclub.databinding.DowrPlayersItemBinding
import com.game.byteclub.model.dowr.Player
import com.game.byteclub.model.dowr.TeamMates
import com.game.byteclub.view.adapter.GamesAdapter

class DowrPlayersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM: Int = 1
        private const val ADD_ITEM: Int = 0
    }

    var teams = mutableListOf<TeamMates>()

    init {
        if (BuildConfig.DEBUG){
            teams.add(TeamMates(Player("Sepehr"), Player("Kianush")))
            teams.add(TeamMates(Player("Akbar"), Player("Reza")))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == ITEM){
            val binding: DowrPlayersItemBinding =
                DowrPlayersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }else {
            val binding = DowrAddPlayerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return AddPlayerViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.firstPlayer.setText(teams[position].firstPlayer.name)
            holder.secondPlayer.setText(teams[position].secondPlayer.name)
        } else if (holder is AddPlayerViewHolder) {
            holder.addPlayerIv.setOnClickListener {
                teams.add(
                    TeamMates(Player("player"), Player("player"))
                )
                notifyItemInserted(itemCount-1)
            }
        }

    }

    override fun getItemCount(): Int {
        return teams.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == itemCount - 1) {
            ADD_ITEM
        } else {
            ITEM
        }
    }


    class ViewHolder(binding: DowrPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {

        val firstPlayer: EditText
        val secondPlayer: EditText

        init {
            firstPlayer = binding.firstPlayerEt
            secondPlayer = binding.secondPlayer
        }

    }

    class AddPlayerViewHolder(binding: DowrAddPlayerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val addPlayerIv: ImageView

        init {
            addPlayerIv = binding.addNewPlayersIv
        }
    }


}