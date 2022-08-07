package com.example.food_android_app;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopCategoriesAdapter extends RecyclerView.Adapter<TopCategoriesAdapter.ViewHolder> {
    private ArrayList<TopCategoriesContainer> container = new ArrayList<>();

    public void setContainer(ArrayList<TopCategoriesContainer> container) {
        this.container = container;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_category_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri uri = Uri.parse(container.get(position).getImgUrl());
        holder.imgView.setImageURI(uri);

        holder.txtView.setText(container.get(position).getName());


    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgView;
        private TextView txtView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            txtView = (TextView) itemView.findViewById(R.id.txtView);
        }
    }
}
