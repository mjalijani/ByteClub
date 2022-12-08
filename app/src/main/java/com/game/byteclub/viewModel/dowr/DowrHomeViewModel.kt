package com.game.byteclub.viewModel.dowr

import androidx.lifecycle.ViewModel
import com.game.byteclub.view.adapter.dowr.DowrPlayersAdapter

class DowrHomeViewModel : ViewModel(){

    val adapter : DowrPlayersAdapter by lazy {
        DowrPlayersAdapter()
    }

    var text = " Welcome to Dowr Game :) "

}