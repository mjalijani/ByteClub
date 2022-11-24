package com.game.byteclub

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.game.byteclub.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity(), AnimationListener {

    private val binding: ActivitySplashScreenBinding by lazy {
        ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        setContentView(binding.root)

        hideActionBar()
        animateWelcome()

    }

    private fun hideActionBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
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