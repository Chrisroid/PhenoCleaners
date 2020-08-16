package com.phenocleaners.phenocleans

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        //declare the animation
        val fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        val fromTop = AnimationUtils.loadAnimation(this, R.anim.from_top)
        val fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom)
        val fromBottom2 = AnimationUtils.loadAnimation(this, R.anim.from_bottom2)

        val view = findViewById<View>(R.id.splash_layout)
        val logo = findViewById<ImageView>(R.id.logo)
        val appName = findViewById<TextView>(R.id.app_name)
        val appMotto = findViewById<TextView>(R.id.app_motto)

        //set the animation
        view.startAnimation(fadeIn)
        logo.startAnimation(fromTop)
        appName.startAnimation(fromBottom)
        appMotto.startAnimation(fromBottom2)

        //intent to onboarding activity
        val getStarted = findViewById<Button>(R.id.btn_get_started)
        getStarted.setOnClickListener {
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        }
    }
}