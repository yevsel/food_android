package com.example.food_android_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;


public class LocalDishesAdapter extends RecyclerView.Adapter<LocalDishesAdapter.ViewHolder> {
    ArrayList<LocalDishContainer> container = new ArrayList<>();
    private Context context;
    private ArrayList basketContainer;
    public LocalDishesAdapter(Context context,ArrayList basketContainer) {
        this.context = context;
        this.basketContainer=basketContainer;
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
        String price = "GH₵ "+container.get(position).getPrice()+".00";
        holder.price.setText(price);

        //OnClick of parent
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ViewDetails.class);
                //Sending the ID to the next page
                intent.putExtra("ID",container.get(position).getImgUrl());
                context.startActivity(intent);
            }
        });

        //Onclick of add Button
        holder.addToBasktet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                basketContainer.add(container.get(position).getImgUrl()+","+container.get(position).getName()+","+container.get(position).getPrice());

                Toast.makeText(context, container.get(position).getName()+" added to basket", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView localImage;
        private TextView name;
        private TextView price;
        private RelativeLayout addToBasktet;
        private ConstraintLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

           localImage = (ImageView) itemView.findViewById(R.id.localImage);
           name = (TextView) itemView.findViewById(R.id.localName);
           price = (TextView) itemView.findViewById(R.id.localPrice);
           parent = (ConstraintLayout) itemView.findViewById(R.id.parent);
           addToBasktet = (RelativeLayout) itemView.findViewById(R.id.addToBasket);

        }
    }
}
