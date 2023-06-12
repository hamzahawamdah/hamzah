package com.example.noor.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.noor.R;

public class splash extends AppCompatActivity {

    Handler h = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        ImageView logo = findViewById(R.id.logo);

        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f);
        fadeIn.setDuration(1500); // Adjust the duration as desired

        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f);
        fadeOut.setDuration(2000); // Adjust the duration as desired

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(fadeIn).before(fadeOut);
        animatorSet.start();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(splash.this, Login.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}