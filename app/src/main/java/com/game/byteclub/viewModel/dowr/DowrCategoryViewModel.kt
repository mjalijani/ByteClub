package com.game.byteclub.viewModel.dowr

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.game.byteclub.R
import com.game.byteclub.view.adapter.dowr.DowrCategoryAdapter

class DowrCategoryViewModel : ViewModel() {

    val adapter: DowrCategoryAdapter by lazy {
        DowrCategoryAdapter()
    }

    fun presentConfiguration(view : View) {
        view.findNavController().navigate(R.id.dowrConfigurationFragment)
    }

}