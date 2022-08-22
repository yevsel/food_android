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
    private TextView itemName,itemPrice,description;
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
        description = (TextView) findViewById(R.id.description);

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
                            itemPrice.append("GHS "+String.valueOf(response.getInt("price")+".00"));
                            imageFromDB = response.getString("imagePreview");
                            description.append("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
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