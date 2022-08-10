package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class ViewDetails extends AppCompatActivity {
    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;

    //Volley for https request
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);

        //HTTPS REQUEST
        mQueue = Volley.newRequestQueue(this);

        itemImage = (ImageView) findViewById(R.id.itemImage);
        itemName = (TextView) findViewById(R.id.itemName);
        itemPrice = (TextView) findViewById(R.id.itemPrice);

        //Get items from Intent
        String ID = getIntent().getStringExtra("ID");
        itemName.setText(ID);
    }

    private void jsonParse(){
        String url = "http://127.0.0.1:4500/category/lunch";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

    }

}