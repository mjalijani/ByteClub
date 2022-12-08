package com.game.byteclub.view.fragment.dowr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.byteclub.databinding.FragmentDowrHomeBinding
import com.game.byteclub.viewModel.dowr.DowrHomeViewModel


class DowrHomeFragment : Fragment() {

    private val binding: FragmentDowrHomeBinding by lazy {
        FragmentDowrHomeBinding.inflate(layoutInflater)
    }

    private val viewModel: DowrHomeViewModel by lazy {
        DowrHomeViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        viewModel.itemTouchHelper.attachToRecyclerView(binding.dowrRv)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}