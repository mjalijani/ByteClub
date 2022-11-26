package com.game.byteclub.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.game.byteclub.R
import com.game.byteclub.databinding.FragmentSplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenFragment : Fragment(), AnimationListener {

    private val binding: FragmentSplashScreenBinding by lazy {
        FragmentSplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = binding.root
        animateWelcome()
        return view
    }

    private fun animateWelcome() {
        val splashAnimation = AnimationUtils.loadAnimation(context, R.anim.anim_splash)
        binding.welcomeTv.animation = splashAnimation
        splashAnimation.setAnimationListener(this)
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        lifecycleScope.launch { 
            delay(1000)
            view?.findNavController()?.navigate(R.id.homeFragment)
        }
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}