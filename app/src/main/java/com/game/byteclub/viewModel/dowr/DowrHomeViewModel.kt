package com.game.byteclub.viewModel.dowr

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.game.byteclub.R
import com.game.byteclub.view.adapter.dowr.DowrPlayersAdapter


class DowrHomeViewModel : ViewModel(){

    val adapter : DowrPlayersAdapter by lazy {
        DowrPlayersAdapter()
    }

    private val simpleItemTouchCallback: ItemTouchHelper.SimpleCallback by lazy {
        object :
            ItemTouchHelper.SimpleCallback(
                0,
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN or ItemTouchHelper.UP
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                adapter.removeItem(viewHolder.adapterPosition)
            }
        }
    }

    fun presentCategory(view: View){
        view.findNavController().navigate(R.id.dowrCategoryFragment)
    }

    val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)


    var text = " Welcome to Dowr Game :) "

}