package com.example.food_android_app;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class LocalDishesAdapter extends RecyclerView.Adapter<LocalDishesAdapter.ViewHolder> {
    ArrayList<LocalDishContainer> container = new ArrayList<>();
    private Context context;
    public LocalDishesAdapter(Context context) {
        this.context = context;
    }

    public void setContainer(ArrayList<LocalDishContainer> container) {
        this.container = container;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.localdish_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri uri = Uri.parse(container.get(position).getImgUrl());
        Glide.with(context).load(uri).centerCrop().into(holder.localImage);

        holder.name.setText(container.get(position).getName());
        holder.price.setText(container.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView localImage;
        private TextView name;
        private TextView price;
        private ConstraintLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           localImage = (ImageView) itemView.findViewById(R.id.localImage);
           name = (TextView) itemView.findViewById(R.id.localName);
           price = (TextView) itemView.findViewById(R.id.localPrice);
           parent = (ConstraintLayout) itemView.findViewById(R.id.parent);

        }
    }
}
