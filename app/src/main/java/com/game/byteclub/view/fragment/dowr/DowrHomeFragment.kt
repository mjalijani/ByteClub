package com.game.byteclub.view.fragment.dowr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.game.byteclub.databinding.FragmentDowrHomeBinding
import com.game.byteclub.viewModel.dowr.DowrHomeViewModel


class DowrHomeFragment : Fragment() {

    private val binding: FragmentDowrHomeBinding by lazy {
        FragmentDowrHomeBinding.inflate(layoutInflater)
    }

    private val viewModel: DowrHomeViewModel by lazy {
        DowrHomeViewModel()
    }

    val callback: OnBackPressedCallback by lazy {
        object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().popBackStack()
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
        viewModel.itemTouchHelper.attachToRecyclerView(binding.dowrRv)
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

}