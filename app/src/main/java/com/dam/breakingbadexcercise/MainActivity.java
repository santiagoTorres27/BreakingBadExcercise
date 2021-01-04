package com.dam.breakingbadexcercise;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView main2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main2 = findViewById(R.id.main2);

        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.rotation);
        main2.startAnimation(anim1);
    }

    public void goCharacter(View view) {
        Intent i = new Intent(this, CharacterActivity.class);
        startActivity(i);
    }

    public void goEpisodes(View view) {
        Intent i = new Intent(this, EpisodesActivity.class);
        startActivity(i);
    }

    public void goQuote(View view) {
        Intent i = new Intent(this, RandomQuoteActivity.class);
        startActivity(i);
    }
}