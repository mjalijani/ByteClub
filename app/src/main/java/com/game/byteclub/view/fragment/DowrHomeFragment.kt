package com.game.byteclub.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.game.byteclub.R
import com.game.byteclub.databinding.FragmentDowrHomeBinding
import com.game.byteclub.viewModel.dowr.DowrHomeViewModel


class DowrHomeFragment : Fragment() {

    private val binding : FragmentDowrHomeBinding by lazy {
        FragmentDowrHomeBinding.inflate(layoutInflater)
    }

    private val viewModel : DowrHomeViewModel by lazy {
        DowrHomeViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            DowrHomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}