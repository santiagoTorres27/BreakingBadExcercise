package com.dam.breakingbadexcercise;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dam.breakingbadexcercise.adapter.CharacterAdapter;
import com.dam.breakingbadexcercise.adapter.CharacterItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CharacterActivity extends AppCompatActivity implements CharacterAdapter.OnItemClickListener {

    public static final String EXTRA_IMG = "imageUrl";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_BIRTHDAY = "birthday";
    public static final String EXTRA_NICKNAME = "nickname";
    public static final String EXTRA_STATUS = "status";
    public static final String EXTRA_PORTRAYED = "portrayed";

    private RecyclerView mRecyclerView;
    private CharacterAdapter mCharacterAdapter;
    private ArrayList<CharacterItem> mCharacterList;
    private RequestQueue mRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mCharacterList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        parseJSON();
    }

    private void parseJSON() {
        String url = "https://breakingbadapi.com/api/characters";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            JSONObject character = null;
                            try {
                                character = new JSONObject(response.get(i).toString());

                                String imageUrl = character.getString("img");
                                String name = character.getString("name");
                                String birthday = character.getString("birthday");
                                String nickname = character.getString("nickname");
                                String status = character.getString("status");
                                String portrayed = character.getString("portrayed");

                                mCharacterList.add(new CharacterItem(imageUrl, name, birthday, nickname, status, portrayed));

                                mCharacterAdapter = new CharacterAdapter(CharacterActivity.this, mCharacterList);
                                mRecyclerView.setAdapter(mCharacterAdapter);

                                mCharacterAdapter.setOnItemClickListener(CharacterActivity.this);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        mRequestQueue.add(request);
    }


    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(this, CharacterDetailActivity.class);
        CharacterItem clickedItem = mCharacterList.get(position);

        i.putExtra(EXTRA_IMG, clickedItem.getImageUrl());
        i.putExtra(EXTRA_NAME, clickedItem.getName());
        i.putExtra(EXTRA_BIRTHDAY, clickedItem.getBirthday());
        i.putExtra(EXTRA_NICKNAME, clickedItem.getNickname());
        i.putExtra(EXTRA_STATUS, clickedItem.getStatus());
        i.putExtra(EXTRA_PORTRAYED, clickedItem.getPortrayed());

        startActivity(i);
    }
}