package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recommendedView;
    private RecyclerView localRecView;
    private ConstraintLayout goToBasket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Container for basket
        ArrayList<String> basketContainer = new ArrayList<>();

        //GO to Basket
        goToBasket = (ConstraintLayout) findViewById(R.id.goToBasket);
        goToBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BasketActivity.class);
                intent.putStringArrayListExtra("basketItems",(ArrayList<String>) basketContainer);
                startActivity(intent);
            }
        });

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
        localContainer.add(new LocalDishContainer("https://images.bolt.eu/store/2022/2022-01-10/f02c37de-ed88-4e59-83dc-8d0f97c5a2f7.jpeg","FUFU AND GOAT MEAT LIGHT SOUP","20","62eb1016d90107a45de60894"));
        localContainer.add(new LocalDishContainer("https://d2j6dbq0eux0bg.cloudfront.net/images/17230018/1073834532.jpg","FUFU AND CHICKEN LIGHT SOUP","20","62eb10a6d90107a45de60896"));
        localContainer.add(new LocalDishContainer("http://1.bp.blogspot.com/-oeL5JMRexf8/Vg05e2HRydI/AAAAAAAABQ4/QhdGAaBcYNc/s1600/P1060496.JPG","OMOTUO AND SOUP WITH MEAT","15","62eb114ea4ee7f69ce86fb97"));
        localContainer.add(new LocalDishContainer("https://myrecipejoint.com/wp-content/uploads/2021/06/61554502_609075879576817_4357456742284525568_n.webp","AKPLE AND ABORBI TADI","20","62eb1177a4ee7f69ce86fb99"));
        localContainer.add(new LocalDishContainer("https://myrecipejoint.com/wp-content/uploads/2021/08/91189016_1473589446167158_5612936886770239653_n.webp","BEANS (PLANTAIN, GARI AND EGG)","15","62eb1236a4ee7f69ce86fb9b"));

        //Local dishes
        localRecView = (RecyclerView) findViewById(R.id.localRecView);
        //local dish adapter
        LocalDishesAdapter localDishesAdapter = new LocalDishesAdapter(this,basketContainer);
        localRecView.setAdapter(localDishesAdapter);
        localDishesAdapter.setContainer(localContainer);
        localRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        //Lunch
        LunchAdapter lunchAdapter = new LunchAdapter(this, basketContainer);
        //Set Container
        ArrayList<LunchContainer> lunchContainer = new ArrayList<>();
        lunchContainer.add(new LunchContainer("https://www.megachicken.com.ng/wp-content/uploads/2019/12/Fried-rice-Vegetage-Salad-and-roasted-Chicken-scaled.jpg","FRIED RICE WITH FRIED CHICKEN","20","62eb13f2a4ee7f69ce86fba9"));
        lunchContainer.add(new LunchContainer("https://d2j6dbq0eux0bg.cloudfront.net/images/17706591/1118448196.jpg","FRIED RICE WITH GRILLED CHICKEN","20","62eb1489a4ee7f69ce86fbab"));
        lunchContainer.add(new LunchContainer("https://www.preciouscore.com/wp-content/uploads/2021/12/Jollof-Rice-With-Chicken-500x500.jpg","JOLLOF RICE WITH GRILLED CHICKEN","22","62eb1345a4ee7f69ce86fba3"));
        //lunchContainer.add(new LunchContainer("https://img-global.cpcdn.com/recipes/f1b7792c8ee3ebcd/1200x630cq70/photo.jpg","PLAIN RICE WITH FISH, SALAD AND SHITOR","15","62eb139ea4ee7f69ce86fba5"));
        lunchContainer.add(new LunchContainer("https://www.preciouscore.com/wp-content/uploads/2021/12/Jollof-Rice-With-Chicken-500x500.jpg","JOLLOF RICE WITH FRIED CHICKEN","13","62eb13cda4ee7f69ce86fba7"));



        lunchAdapter.setLunchContainer(lunchContainer);

        //Get the recycler view
        RecyclerView lunchRecView = (RecyclerView) findViewById(R.id.lunchRecView);
        lunchRecView.setAdapter(lunchAdapter);

        //Layout Manager
        lunchRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));



    }





}