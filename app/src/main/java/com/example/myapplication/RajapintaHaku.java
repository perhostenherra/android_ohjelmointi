package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class RajapintaHaku extends AppCompatActivity {

    Request requestQueue;
    TextView textView;
    String url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=1000&resultsFrom=0&name=suomen&companyRegistrationFrom=2000-01-01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajapinta_haku);


        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
            // get data via the key
        String searchTerm = extras.getString("searchTerm");
        if (searchTerm != null) {
            url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=1000&resultsFrom=0&name="+searchTerm+"&companyRegistrationFrom=2000-01-01";
        }

        RequestQueue queue = Volley.newRequestQueue(this);


        textView = findViewById(R.id.textView);
        JsonArrayRequest jor = new JsonArrayRequest (
                Request.Method.GET, // the HTTP method to use
                url, // url
                null, // null indicates, that no parameters will be posted along with request
                new Response.Listener<JSONArray>() { // listener to receive the Json response
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONArray responseItems = (JSONArray) response.getJSONArray(Integer.parseInt("results"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() { // error listener
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                });

            //jor.setRetryPolicy();
            queue.add(jor);
    }
}