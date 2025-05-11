package com.example.kmpay.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.kmpay.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Make sure the ImageView ID is correct
        val logo: ImageView = findViewById(R.id.splash_logo)

        // Load and start animation
        val animation = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        logo.startAnimation(animation)

        // Delay 2 seconds and move to MainActivity
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 2000)
    }
}
