package com.example.food_android_app;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ViewDetails extends AppCompatActivity {
    private ImageView itemImage;
    private TextView itemName;
    private TextView itemPrice;
    private String IDToFetch;

    private String imageFromDB;

    //Volley for https request
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_details);


        IDToFetch = getIntent().getStringExtra("ID");

        //Getting views
        itemImage = (ImageView) findViewById(R.id.itemImage);
        itemName = (TextView) findViewById(R.id.itemName);
        itemPrice = (TextView) findViewById(R.id.itemPrice);

        //HTTPS REQUEST
        mQueue = Volley.newRequestQueue(this);
        jsonParse(IDToFetch);


    }

    private void jsonParse(String idToFetch){
        String url = "https://micjeanapi.herokuapp.com/food/get/"+idToFetch;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            //Toast.makeText(ViewDetails.this, response.getString("imagePreview"), Toast.LENGTH_SHORT).show();
                            itemName.append(response.getString("name"));
                            itemPrice.append(String.valueOf(response.getInt("price")));
                            imageFromDB = response.getString("imagePreview");

                            //Glide
                            Uri uri = Uri.parse(response.getString("imagePreview"));
                            Glide.with(ViewDetails.this).load(uri).centerCrop().into(itemImage);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
        });
        mQueue.add(jsonObjectRequest);

    }

}