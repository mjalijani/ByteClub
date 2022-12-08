package com.game.byteclub.viewModel

import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.R
import com.game.byteclub.model.Game
import com.game.byteclub.view.adapter.GamesAdapter

class HomeViewModel : ViewModel() {

    var dowrTxt = "Dowr"
    private val adapter: GamesAdapter by lazy {
        GamesAdapter(mutableListOf(
            Game("Dowr",R.id.dowrHomeFragment),
            Game("Spy Fall",R.id.dowrHomeFragment) //todo : change it later
        ))
    }

    fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
        val manager = LinearLayoutManager(recyclerView.context)
        manager.orientation = LinearLayoutManager.VERTICAL
        manager.reverseLayout = true
        recyclerView.layoutManager = manager
    }

}