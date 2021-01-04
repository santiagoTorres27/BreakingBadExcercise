package com.dam.breakingbadexcercise;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.toolbox.StringRequest;
import com.squareup.picasso.Picasso;

import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_BIRTHDAY;
import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_IMG;
import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_NAME;
import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_NICKNAME;
import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_PORTRAYED;
import static com.dam.breakingbadexcercise.CharacterActivity.EXTRA_STATUS;

public class CharacterDetailActivity extends AppCompatActivity {

    ImageView ivProfile;
    TextView tvName;
    TextView tvBirthday;
    TextView tvNickname;
    TextView tvStatus;
    TextView tvPortrayed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);

        Intent i = getIntent();

        ivProfile = findViewById(R.id.ivProfile);
        tvName = findViewById(R.id.tvName);
        tvBirthday = findViewById(R.id.tvBirthday);
        tvNickname = findViewById(R.id.tvNickname);
        tvStatus = findViewById(R.id.tvStatus);
        tvPortrayed = findViewById(R.id.tvPortrayed);

        String imageUrl = i.getStringExtra(EXTRA_IMG);
        String name = i.getStringExtra(EXTRA_NAME);
        String birthday = i.getStringExtra(EXTRA_BIRTHDAY);
        String nickname = i.getStringExtra(EXTRA_NICKNAME);
        String status = i.getStringExtra(EXTRA_STATUS);
        String portrayed = i.getStringExtra(EXTRA_PORTRAYED);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(ivProfile);
        tvName.setText(name);
        tvBirthday.setText(birthday);
        tvNickname.setText(nickname);
        tvStatus.setText(status);
        tvPortrayed.setText(portrayed);
    }
}