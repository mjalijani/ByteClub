package com.game.byteclub.view.fragment.dowr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.byteclub.databinding.FragmentDowrConfigurationBinding
import com.game.byteclub.viewModel.dowr.DowrConfigurationViewModel

class DowrConfigurationFragment : Fragment() {

    val binding : FragmentDowrConfigurationBinding by lazy {
        FragmentDowrConfigurationBinding.inflate(layoutInflater)
    }

    val viewModel : DowrConfigurationViewModel by lazy {
        DowrConfigurationViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}