package com.ihfazh.myrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridHeroAdapter extends RecyclerView.Adapter<GridHeroAdapter.GridViewHolder> {

    public interface OnItemClickCallback{
        void onItemClicked(Hero data);
    }

    private ArrayList<Hero> heroesList;
    private OnItemClickCallback onItemClickCallback;

    public GridHeroAdapter(ArrayList<Hero> list){
        this.heroesList = list;

    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hero, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(heroesList.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.img);
        holder.itemView.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        onItemClickCallback.onItemClicked(
                                heroesList.get(holder.getAdapterPosition())
                        );
                    }
                }
        );
    }

    public void setOnItemClickCallback(OnItemClickCallback callback){
        onItemClickCallback = callback;
    }

    @Override
    public int getItemCount() {
        return heroesList.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView img ;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
