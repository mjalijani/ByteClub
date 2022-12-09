package com.game.byteclub.view.fragment.dowr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.game.byteclub.databinding.FragmentDowrCategoryBinding
import com.game.byteclub.viewModel.dowr.DowrCategoryViewModel

class DowrCategoryFragment : Fragment() {

    private val binding: FragmentDowrCategoryBinding by lazy {
        FragmentDowrCategoryBinding.inflate(layoutInflater)
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
        binding.viewModel = DowrCategoryViewModel()
        binding.categoryRv.layoutManager = GridLayoutManager(context,3)
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}