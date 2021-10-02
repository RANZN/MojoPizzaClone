package com.ranzan.mojopizzaclone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class Splash : AppCompatActivity() {
    private lateinit var lottieAnimationView: LottieAnimationView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    var animation1: Animation? = null
    var animation2: Animation? = null
    var animation3: Animation? = null
    var animation4: Animation? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        lottieAnimationView = findViewById(R.id.lottie)
        img1 = findViewById(R.id.imageView)
        img2 = findViewById(R.id.imageView2)
        img3 = findViewById(R.id.imageView3)
        animation1 = AnimationUtils.loadAnimation(applicationContext, R.anim.text_anim)
        animation2 = AnimationUtils.loadAnimation(applicationContext, R.anim.logo)
        animation3 = AnimationUtils.loadAnimation(applicationContext, R.anim.tag)
        animation4 = AnimationUtils.loadAnimation(applicationContext, R.anim.lotte)
        img1.setAnimation(animation2)
        img2.setAnimation(animation1)
        img3.setAnimation(animation3)
        lottieAnimationView.setAnimation(animation4)

        //to remove statusbar

        //splash screen
        val runnable = Runnable {
            val intent = Intent(this@Splash, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
        val handler = Handler()
        handler.postDelayed(runnable, 5000)
    }
}