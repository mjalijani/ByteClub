package com.game.byteclub.view.fragment.dowr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.game.byteclub.databinding.FragmentDowrConfigurationBinding
import com.game.byteclub.viewModel.dowr.DowrConfigurationViewModel

class DowrConfigurationFragment : Fragment() {

    val binding: FragmentDowrConfigurationBinding by lazy {
        FragmentDowrConfigurationBinding.inflate(layoutInflater)
    }

    val viewModel: DowrConfigurationViewModel by lazy {
        DowrConfigurationViewModel(binding)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.timer.observe(this) {
            binding.timeTv.text = it.toString()
        }

        viewModel.roundLimit.observe(this) {
            binding.roundValueTv.text = it.toString()
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.viewModel = viewModel
        return binding.root
    }
}