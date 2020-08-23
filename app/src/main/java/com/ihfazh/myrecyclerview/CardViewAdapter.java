package com.ihfazh.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {
    ArrayList<Hero> listHeroes;

    public CardViewAdapter(ArrayList<Hero> list){
        this.listHeroes = list;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_hero, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewHolder holder, final int position) {
        Hero hero = listHeroes.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.photo);

        System.out.println(hero.getDetail());
        holder.tvDetail.setText(hero.getDetail());
        holder.tvName.setText(hero.getName());


        holder.fav.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Favorite " + listHeroes.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), "Share " + listHeroes.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listHeroes.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView tvName, tvDetail;
        Button fav, share;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_detail);
            fav = itemView.findViewById(R.id.btn_set_favorite);
            share = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
