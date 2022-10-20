package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class RajapintaHaku extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static final String TAG ="MyAppMessage";
    Request requestQueue;
    ProgressBar progressBar;
    TextView textError;
    TextView textView;
    TextView textResults;
    RecyclerAdapter mAdapter;
    String url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=1000&resultsFrom=0&name=suomen&companyRegistrationFrom=2000-01-01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajapinta_haku);
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String searchTerm = extras.getString("searchTerm");
            if (searchTerm != null) {
                url = "http://avoindata.prh.fi/bis/v1?totalResults=false&maxResults=1000&resultsFrom=0&name="+searchTerm+"&companyRegistrationFrom=2000-01-01";
            }
            Log.e(TAG,url);

        }
            // get data via the key


        RequestQueue queue = Volley.newRequestQueue(this);


        ArrayList<Company> companies = new ArrayList<Company>();
        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recycleView);
        progressBar = findViewById(R.id.progressBar);
        textError = findViewById(R.id.textError);
        textResults = findViewById(R.id.textResults);


        JsonObjectRequest jor = new JsonObjectRequest(
                Request.Method.GET, // the HTTP method to use
                url, // url
                null, // null indicates, that no parameters will be posted along with request
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray responseItems = (JSONArray) response.getJSONArray("results");
                            for (int i = 0 ; i < responseItems.length(); i++) {
                                Company currentCompany = new Company();
                                JSONObject obj = responseItems.getJSONObject(i);
                                String A = obj.getString("businessId");
                                String B = obj.getString("name");
                                String C = obj.getString("registrationDate");
                                String D = obj.getString("companyForm");
                                Log.e(TAG,A + " " + B + " " + C +" "+ D + " ");
                                currentCompany.setName(B);
                                currentCompany.setBusinessId(A);
                                currentCompany.setRegistrationDate(C);
                                currentCompany.setCompanyForm(D);


                                companies.add(currentCompany);
                                mAdapter = new RecyclerAdapter(companies);
                                recyclerView.setAdapter(mAdapter);
                                progressBar.setVisibility(View.GONE);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() { // error listener
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG,"No companies found");
                        recyclerView.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        textError.setText("No companies found :(");
                    }
                });

            //jor.setRetryPolicy();

            jor.setRetryPolicy(new DefaultRetryPolicy(20 * 1000, 1, 1.0f));
            queue.add(jor);



    }


}