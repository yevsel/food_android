package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket);

        Bundle bundle = getIntent().getExtras();

        ArrayList<String> basketItems = bundle.getStringArrayList("basketItems");

        RecyclerView basketRecView = (RecyclerView) findViewById(R.id.basketRecView);
        Toast.makeText(this, "Hello from Ghana", Toast.LENGTH_SHORT).show();
        BasketAdapter basketAdapter = new BasketAdapter(this);
        basketAdapter.setBasketItems(basketItems);
        basketAdapter.notifyDataSetChanged();
        basketRecView.setAdapter(basketAdapter);
        basketRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }
}