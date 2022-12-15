package com.game.byteclub.viewModel.dowr

import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.game.byteclub.R
import com.game.byteclub.databinding.FragmentDowrConfigurationBinding
import com.game.byteclub.repository.DowrRepository

class DowrConfigurationViewModel(val binding: FragmentDowrConfigurationBinding) : ViewModel() {

    var timer: MutableLiveData<Int> = MutableLiveData(3)
    var roundLimit: MutableLiveData<Int> = MutableLiveData(3)
    private var helper: Boolean = true


    fun getTimer(): String {
        return timer.toString()
    }

    fun getRounds(): String {
        return roundLimit.toString()
    }

    fun enabledClick(view: View) {
        if (helper) {
            view.setBackgroundDrawable(binding.root.context.resources.getDrawable(R.drawable.bg_rectangle_light_primary_roundted))
            (view as TextView).setTextColor(binding.root.context.resources.getColor(R.color.primary_dark))
            view.text = "Disabled"
        } else {
            view.setBackgroundDrawable(binding.root.context.resources.getDrawable(R.drawable.bg_rectangle_primary_rounded))
            (view as TextView).setTextColor(binding.root.context.resources.getColor(R.color.secondary))
            view.text = "Enabled"
        }
        helper = !helper
    }

    fun increaseTime(view: View) {
        timer.value?.let {
            if (it < 10) {
                timer.postValue(it.inc())
            }
        }
    }

    fun decreaseTime(view: View) {
        timer.value?.let {
            if (it > 0) {
                timer.postValue(it.dec())
            }
        }
    }

    fun increaseRound(view: View) {
        roundLimit.value?.let {
            if (it < 10) {
                roundLimit.postValue(it.inc())
            }
        }
    }

    fun decreaseRound(view: View) {
        roundLimit.value?.let {
            if (it > 0) {
                roundLimit.postValue(it.dec())
            }
        }
    }


    //todo : for later
    private val categoryRepository: DowrRepository by lazy {
        DowrRepository()
    }

    private var categoryResponseLiveData: MutableLiveData<List<String>> =
        categoryRepository.getCategory()

    fun getCategory(name: String) {
        categoryRepository.getCategory(name)
    }

}