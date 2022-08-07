package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView topCatRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<TopCategoriesContainer> container = new ArrayList<>();
        container.add(new TopCategoriesContainer("https://travelfoodatlas.com/wp-content/uploads/2022/07/Ghana-Waakye.jpg.webp","Waakye"));


        topCatRecView = (RecyclerView) findViewById(R.id.topCatRecView);
        TopCategoriesAdapter topCategoriesAdapter = new TopCategoriesAdapter();
        topCategoriesAdapter.setContainer(container);
        topCatRecView.setAdapter(topCategoriesAdapter);
        //Set Layout
        topCatRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

}