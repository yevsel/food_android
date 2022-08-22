package com.example.food_android_app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.ViewHolder> {
    private ArrayList<RecommendedContainer> container = new ArrayList<>();
    private Context context;

    public RecommendedAdapter(Context context) {
        this.context=context;
    }

    public void setContainer(ArrayList<RecommendedContainer> container) {
        this.container = container;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recommended_layout,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Uri url = Uri.parse(container.get(position).getImgUrl());
        //Using Glide
        Glide.with(context).load(url).centerCrop().into(holder.imgView);


        String name = container.get(position).getName();
        holder.txtView.setText(name);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, container.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,ViewDetails.class);
                intent.putExtra("imageURL",container.get(position).getImgUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return container.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgView;
        private TextView txtView;
        private LinearLayout parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            txtView = (TextView) itemView.findViewById(R.id.txtView);
            parent = (LinearLayout) itemView.findViewById(R.id.parent);

        }
    }
}
