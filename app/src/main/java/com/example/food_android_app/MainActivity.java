package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recommendedView;
    private RecyclerView localRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<RecommendedContainer> container = new ArrayList<>();
        container.add(new RecommendedContainer("https://travelfoodatlas.com/wp-content/uploads/2022/07/Ghana-Waakye.jpg.webp","Waakye"));
        container.add(new RecommendedContainer("https://cdn.shopify.com/s/files/1/1153/4418/articles/banku-tilapia_800x.jpeg?v=1558561132","Banku"));
        container.add(new RecommendedContainer("https://images.bolt.eu/store/2022/2022-01-10/f02c37de-ed88-4e59-83dc-8d0f97c5a2f7.jpeg","Fufu"));

        recommendedView = (RecyclerView) findViewById(R.id.recommendedView);
        RecommendedAdapter topCategoriesAdapter = new RecommendedAdapter(this);
        topCategoriesAdapter.setContainer(container);
        recommendedView.setAdapter(topCategoriesAdapter);
        //Set Layout
        recommendedView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        ArrayList<LocalDishContainer> localContainer = new ArrayList<>();
        localContainer.add(new LocalDishContainer("http://1.bp.blogspot.com/-oeL5JMRexf8/Vg05e2HRydI/AAAAAAAABQ4/QhdGAaBcYNc/s1600/P1060496.JPG","OMOTUO AND GROUNDNUT SOUP WITH MEAT","GHs 20"));
        localContainer.add(new LocalDishContainer("https://newsghana.com.gh/wp-content/uploads/2022/06/Gari-and-Beans.jpg","RED RED (PLANTAIN, BEANS, GARI AND EGG)","GHs 20"));
        localContainer.add(new LocalDishContainer("https://images.bolt.eu/store/2022/2022-02-03/c4eba9eb-b109-4bbf-b4cb-75ba2d29e8fb.jpeg","BANKU WITH OKRO STEW AND MEAT","GHs 15"));

        //Local dishes
        localRecView = (RecyclerView) findViewById(R.id.localRecView);
        //local dish adapter
        LocalDishesAdapter localDishesAdapter = new LocalDishesAdapter(this);
        localRecView.setAdapter(localDishesAdapter);
        localDishesAdapter.setContainer(localContainer);
        localRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //Lunch
        LunchAdapter lunchAdapter = new LunchAdapter(this);
        //Set Container
        ArrayList<LunchContainer> lunchContainer = new ArrayList<>();
        lunchContainer.add(new LunchContainer("https://ocdn.eu/images/pulscms/ZjU7MDA_/f9421eb56c22e057c3a88dc626a3d3b5.jpeg","Yam and Stew","22"));
        lunchContainer.add(new LunchContainer("https://buzzghana.com/wp-content/uploads/2014/08/egusi-soup.jpg","Pounded Yam","15"));
        lunchContainer.add(new LunchContainer("https://pbs.twimg.com/media/DbOVL-OWkAMxpDk.jpg","EbunuEbunu","13"));

        lunchAdapter.setLunchContainer(lunchContainer);

        //Get the recycler view
        RecyclerView lunchRecView = (RecyclerView) findViewById(R.id.lunchRecView);
        lunchRecView.setAdapter(lunchAdapter);

        //Layout Manager
        lunchRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        //Get request
        OkHttpClient client = new OkHttpClient();

    }



}