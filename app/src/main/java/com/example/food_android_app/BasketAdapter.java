package com.example.food_android_app;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder>{
    private ArrayList<String> basketItems = new ArrayList<>();
    private Context context;

    public BasketAdapter(Context context) {
        this.context = context;
    }

    public void setBasketItems(ArrayList<String> basketItems) {
        this.basketItems = basketItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.basket_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri uri = Uri.parse(basketItems.get(position));
        Glide.with(context).load(uri).centerCrop().into(holder.basketItemImage);
    }

    @Override
    public int getItemCount() {
        return basketItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView basketItemImage;
        private TextView basketItemName;
        private TextView basketItemPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            basketItemImage = (ImageView) itemView.findViewById(R.id.basketItemImage);
            basketItemName = (TextView) itemView.findViewById(R.id.basketItemName);
            basketItemPrice = (TextView) itemView.findViewById(R.id.basketItemPrice);

        }
    }
}
