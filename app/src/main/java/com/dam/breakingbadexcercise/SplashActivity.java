package com.dam.breakingbadexcercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

public class SplashActivity extends AppCompatActivity {

    View bg2;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bg2 = findViewById(R.id.bg2);
        logo = findViewById(R.id.logo);

        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.move1);
        bg2.startAnimation(anim1);

        Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        logo.startAnimation(anim2);

        openApp(true);
    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}