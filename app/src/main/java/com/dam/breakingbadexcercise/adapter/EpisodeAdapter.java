package com.dam.breakingbadexcercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.breakingbadexcercise.R;

import java.util.ArrayList;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private Context mContext;
    private ArrayList<EpisodeItem> mEpisodeList;

    public EpisodeAdapter(Context context, ArrayList<EpisodeItem> episodeList) {
        mContext = context;
        mEpisodeList = episodeList;
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.episode_item, parent, false);
        return new EpisodeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        EpisodeItem currentItem = mEpisodeList.get(position);

        String season = currentItem.getSeason();
        String title = currentItem.getTitle();
        String airDate = currentItem.getAirDate();

        holder.tvSeason.setText(season);
        holder.tvTitle.setText(title);
        holder.tvAirDate.setText(airDate);
    }

    @Override
    public int getItemCount() {
        return mEpisodeList.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {

        TextView tvSeason;
        TextView tvTitle;
        TextView tvAirDate;

        public EpisodeViewHolder(@NonNull View itemView) {
            super(itemView);

            tvSeason = itemView.findViewById(R.id.tvSeason);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAirDate = itemView.findViewById(R.id.tvAirDate);
        }
    }
}
