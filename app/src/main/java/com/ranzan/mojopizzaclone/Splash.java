package com.ranzan.mojopizzaclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Splash extends AppCompatActivity {

    private LottieAnimationView lottieAnimationView;
    private ImageView img1,img2,img3;
    Animation animation1,animation2,animation3,animation4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        lottieAnimationView=findViewById(R.id.lottie);
        img1=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView2);
        img3=findViewById(R.id.imageView3);

        animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.text_anim);
        animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.logo);
        animation3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tag);
        animation4= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.lotte);

        img1.setAnimation(animation2);
        img2.setAnimation(animation1);
        img3.setAnimation(animation3);
        lottieAnimationView.setAnimation(animation4);

        //to remove statusbar

        //splash screen
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(Splash.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        };
        Handler handler=new Handler();
        handler.postDelayed(runnable,2000);
    }
}