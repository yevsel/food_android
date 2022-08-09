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

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LunchAdapter extends RecyclerView.Adapter<LunchAdapter.ViewHolder>{
    ArrayList<LunchContainer> lunchContainer = new ArrayList<>();
    private Context context;
    public LunchAdapter(Context context) {
        this.context=context;
    }

    //Setter

    public void setLunchContainer(ArrayList<LunchContainer> lunchContainer) {
        this.lunchContainer = lunchContainer;
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
        //Glide the images
        Uri uri = Uri.parse(lunchContainer.get(position).getLunchImage());
        Glide.with(context).load(uri).centerCrop().into(holder.lunchImage);

        holder.lunchName.setText(lunchContainer.get(position).getLunchName());
        holder.lunchPrice.setText(lunchContainer.get(position).getLunchPrice());

    }

    @Override
    public int getItemCount() {
        return lunchContainer.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        //Using the layout of local dishes
        private ImageView lunchImage;
        private TextView lunchPrice;
        private TextView lunchName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lunchImage = (ImageView) itemView.findViewById(R.id.localImage);
            lunchPrice = (TextView) itemView.findViewById(R.id.localPrice);
            lunchName = (TextView) itemView.findViewById(R.id.localName);
        }
    }
}