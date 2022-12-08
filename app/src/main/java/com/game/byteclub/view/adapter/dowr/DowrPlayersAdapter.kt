package com.game.byteclub.view.adapter.dowr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.BuildConfig
import com.game.byteclub.databinding.DowrAddPlayerBinding
import com.game.byteclub.databinding.DowrPlayersItemBinding
import com.game.byteclub.model.dowr.Player
import com.game.byteclub.model.dowr.TeamMates

class DowrPlayersAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM: Int = 1
        private const val ADD_ITEM: Int = 0
    }

    var teams = mutableListOf<TeamMates>()

    init {
        if (BuildConfig.DEBUG) {
            teams.add(TeamMates(Player("Sepehr"), Player("Kianush")))
            teams.add(TeamMates(Player("Akbar"), Player("Reza")))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ITEM) {
            val binding: DowrPlayersItemBinding =
                DowrPlayersItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            ViewHolder(binding)
        } else {
            val binding =
                DowrAddPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            val holder = AddPlayerViewHolder(binding)
            holder.addPlayerIv.setOnClickListener {
                teams.add(TeamMates(Player(""), Player("")))
                notifyItemInserted(itemCount - 1)
            }
            holder
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder) {
            holder.setTeam(teams[position])
        } else {
            if (itemCount > 10) {
                (holder as AddPlayerViewHolder).itemView.visibility = View.GONE
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

    fun removeItem(position: Int) {
        teams.removeAt(position)
        notifyItemRemoved(position)
    }


    class ViewHolder(val binding: DowrPlayersItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setTeam(teamMates: TeamMates) {
            binding.team = teamMates
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