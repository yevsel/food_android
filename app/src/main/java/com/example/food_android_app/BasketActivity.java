package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> basketItems = bundle.getStringArrayList("basketItems");

        //Calculate total Price
        int total =0;

        for(int i=0;i<basketItems.size();i++){
            total+=Integer.parseInt(basketItems.get(i).split(",",10)[2]);
        }

        TextView totalPrice = (TextView) findViewById(R.id.totalPrice);
        totalPrice.setText("GHS "+Integer.toString(total));

        RecyclerView basketRecView = (RecyclerView) findViewById(R.id.basketRecView);

        BasketAdapter basketAdapter = new BasketAdapter(this);
        basketAdapter.setBasketItems(basketItems);

        basketRecView.setAdapter(basketAdapter);
        basketRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    }
}