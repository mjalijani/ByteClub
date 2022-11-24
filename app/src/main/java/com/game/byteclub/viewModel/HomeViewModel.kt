package com.game.byteclub.viewModel

import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.view.adapter.GamesAdapter

class HomeViewModel : ViewModel() {

    var dowrTxt = "Dowr"
    private val adapter: GamesAdapter by lazy {
        GamesAdapter(mutableListOf("Dowr", "SpyFall"))
    }

    fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.adapter = adapter
        val manager = LinearLayoutManager(recyclerView.context)
        manager.orientation = LinearLayoutManager.VERTICAL
        manager.reverseLayout = true
        recyclerView.layoutManager = manager
    }

}