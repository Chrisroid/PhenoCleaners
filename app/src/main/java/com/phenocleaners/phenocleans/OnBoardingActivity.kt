package com.phenocleaners.phenocleans

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    // Viewpager slide Adapter Title and description textview
    private val introSlideAdapter = IntroSlideAdapter(
        listOf(
            IntroSlide(
                "Standard Laundry Process",
                "At PHENOCLEANERS, we treat your laundry with UTMOST care with a GOAL of putting ROYALTY to your look",
                R.drawable.slider_picture1
            ),
            IntroSlide(
                "Home Pickup and Delivery",
                "Do not leave your home!\n We'll pickup and deliver your laundry duly",
                R.drawable.slider_picture2
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        introSlideViewPager.adapter = introSlideAdapter
        setupIndicators()
        setCurrentIndicator(0)
        introSlideViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        // Intent from Login button to LoginActivity.java
        val goToLogin = findViewById<Button>(R.id.btn_login)
        goToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        //Intent from SignUp button to SignUp Activity.java
        val goToSignUp = findViewById<Button>(R.id.btn_sign_up)
        goToSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

        //Setting up the Indicators function
        private fun setupIndicators() {
            val indicators = arrayOfNulls<ImageView>(introSlideAdapter.itemCount)
            val layoutParams: LinearLayout.LayoutParams =
                LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
            layoutParams.setMargins(8, 0, 8, 0)
            for (i in indicators.indices) {
                indicators[i] = ImageView(applicationContext)
                indicators[i].apply {
                    this?.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive
                        )
                    )
                    this?.layoutParams = layoutParams
                }
                indicatorsContainer.addView(indicators[i])
            }
        }

        //Setting up the currenr indicator function
        private fun setCurrentIndicator(index: Int) {
            val childCount = indicatorsContainer.childCount
            for (i in 0 until childCount) {
                val imageView = indicatorsContainer[i] as ImageView
                if (i == index) {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_active
                        )
                    )
                } else {
                    imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.indicator_inactive
                        )
                    )
                }
            }
        }
}