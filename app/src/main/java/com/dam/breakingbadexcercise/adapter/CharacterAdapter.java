package com.dam.breakingbadexcercise.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dam.breakingbadexcercise.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {
    private Context mContext;
    private ArrayList<CharacterItem> mCharacterList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public CharacterAdapter(Context mContext, ArrayList<CharacterItem> mCharacterList) {
        this.mContext = mContext;
        this.mCharacterList = mCharacterList;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.character_item, parent, false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        CharacterItem currentItem = mCharacterList.get(position);

        String imageUrl = currentItem.getImageUrl();
        String name = currentItem.getName();
        String birthday = currentItem.getBirthday();
        String nickname = currentItem.getNickname();

        holder.mTvName.setText(name);
        holder.mTvBirthday.setText("Birthday: " + birthday);
        holder.mTvNickname.setText("Nickname: " + nickname);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mCharacterList.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTvName;
        public TextView mTvBirthday;
        public TextView mTvNickname;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageView);
            mTvName = itemView.findViewById(R.id.tvName);
            mTvBirthday = itemView.findViewById(R.id.tvBirthday);
            mTvNickname = itemView.findViewById(R.id.tvNickname);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
