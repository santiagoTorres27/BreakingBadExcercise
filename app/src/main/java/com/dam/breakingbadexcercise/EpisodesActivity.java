package com.dam.breakingbadexcercise;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.dam.breakingbadexcercise.adapter.EpisodeAdapter;
import com.dam.breakingbadexcercise.adapter.EpisodeItem;
import com.google.android.material.chip.Chip;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class EpisodesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private EpisodeAdapter mEpisodeAdapter;
    private ArrayList<EpisodeItem> mEpisodeList;
    private ArrayList<EpisodeItem> mEpisodeListSeason1;
    private ArrayList<EpisodeItem> mEpisodeListSeason2;
    private ArrayList<EpisodeItem> mEpisodeListSeason3;
    private ArrayList<EpisodeItem> mEpisodeListSeason4;
    private ArrayList<EpisodeItem> mEpisodeListSeason5;
    private RequestQueue mRequestQueue;

    Chip allSeasons;
    Chip season2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodes);

        allSeasons = findViewById(R.id.allSeasons);
        season2 = findViewById(R.id.season1);
        allSeasons.setChecked(true);

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mEpisodeList = new ArrayList<>();
        mEpisodeListSeason1 = new ArrayList<>();
        mEpisodeListSeason2 = new ArrayList<>();
        mEpisodeListSeason3 = new ArrayList<>();
        mEpisodeListSeason4 = new ArrayList<>();
        mEpisodeListSeason5 = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        parseJSON();

    }

    private void parseJSON() {
        String url = "https://breakingbadapi.com/api/episodes";

        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int size = response.length();
                        for (int i = 0; i < size; i++) {
                            JSONObject episode = null;
                            try {
                                episode = new JSONObject(response.get(i).toString());

                                String season = episode.getString("season");
                                String title = episode.getString("title");
                                String airDate = episode.getString("air_date");

                                mEpisodeList.add(new EpisodeItem(season, title, airDate));
                                mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeList);
                                mRecyclerView.setAdapter(mEpisodeAdapter);

                                if (season.equals("1")) {
                                    mEpisodeListSeason1.add(new EpisodeItem(season, title, airDate));

                                } else if (season.equals("2")) {
                                    mEpisodeListSeason2.add(new EpisodeItem(season, title, airDate));

                                } else if (season.equals("3")) {
                                    mEpisodeListSeason3.add(new EpisodeItem(season, title, airDate));

                                } else if (season.equals("4")) {
                                    mEpisodeListSeason4.add(new EpisodeItem(season, title, airDate));

                                } else if (season.equals("5")) {
                                    mEpisodeListSeason5.add(new EpisodeItem(season, title, airDate));
                                }

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

    public void getAllEpisodes(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeList);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }

    public void getSeason1(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeListSeason1);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }

    public void getSeason2(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeListSeason2);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }

    public void getSeason3(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeListSeason3);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }

    public void getSeason4(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeListSeason4);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }

    public void getSeason5(View view) {
        mEpisodeAdapter = new EpisodeAdapter(EpisodesActivity.this, mEpisodeListSeason5);
        mRecyclerView.setAdapter(mEpisodeAdapter);
    }
}