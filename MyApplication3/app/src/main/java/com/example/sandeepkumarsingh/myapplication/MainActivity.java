package com.example.sandeepkumarsingh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Country> countries;
    private RecyclerViewAdapter adapter;

    private final static String JSON_URL =
            "https://gist.githubusercontent.com/DevExchanges/29e8bb477bf520b3c076b1073a9fcd0f/raw/ad8fb0759cebde0e8ed492794ea8cc0bee184bb9/country.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        countries = new ArrayList<>();
        adapter = new RecyclerViewAdapter(countries);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Load JSON data from an URL
        new GetCountriesFromURLTask(this, JSON_URL).execute();
    }

    public void parseJsonResponse(String result) {
        try {
            JSONObject json = new JSONObject(result);
            JSONArray jArray = new JSONArray(json.getString("message"));
            countries.clear();
            for (int i = 0; i < jArray.length(); i++) {

                JSONObject jObject = jArray.getJSONObject(i);
                Country country = new Country();
                country.setId(jObject.getInt("id"));
                country.setName(jObject.getString("name"));
                countries.add(country);
            }

            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
