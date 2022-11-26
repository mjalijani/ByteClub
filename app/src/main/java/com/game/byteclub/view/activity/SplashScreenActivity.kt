package com.game.byteclub.view.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.game.byteclub.R
import com.game.byteclub.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity(), AnimationListener {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        hideStatusBar()
        animateWelcome()
    }

    private fun hideStatusBar() {
        if (Build.VERSION.SDK_INT >= 30) {
            window.decorView.windowInsetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
            actionBar?.hide()
        }
    }


    private fun animateWelcome() {
        val splashAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_splash)
        binding.welcomeTv.animation = splashAnimation
        splashAnimation.setAnimationListener(this)
    }

    override fun onAnimationStart(p0: Animation?) {

    }

    override fun onAnimationEnd(p0: Animation?) {
        Thread.sleep(1000)
        startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
        finish()
    }

    override fun onAnimationRepeat(p0: Animation?) {

    }
}