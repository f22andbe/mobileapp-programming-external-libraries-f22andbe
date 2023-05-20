package com.example.networking;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("FieldCanBeLocal")
public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    //private final String JSON_FILE = "mountains.json";
    private String mountainsJSON;
    private ArrayList<Mountain> mountainArrayList;
    private Gson gson;
    RecyclerView recyclerView;
    Type type;
    MountainViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mountainArrayList = new ArrayList<Mountain>();

        /* Read in recyclerview */
        recyclerView = findViewById(R.id.recyclerView);

        /* Set up adapter */
        mAdapter = new MountainViewAdapter(this, mountainArrayList);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        /* setup JSON parser */
        gson = new Gson();
        type = new TypeToken<ArrayList<Mountain>>() {}.getType();

    }


    /* parse JSON data and update view */
    @Override
    public void onPostExecute(String json) {
        /* parse json into Mountain objects */
        //mountainArrayList.clear();
        mountainArrayList.addAll(gson.fromJson(json, type));
        //Log.d("onPostExecute(): ", mountainArrayList.toString());
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        /* start JsonTask and fetch data */
        if (id == R.id.action_get_data) {
            Log.d("onOptionItemSelected","Get JSON data from web");
            /* get JSON data from webservice */

            new JsonTask(this).execute(JSON_URL);
            return true;
        }

        /* clear data and RecyclerView */
        if (id == R.id.action_clear_data) {
            Log.d("onOptionItemSelected","clear data");
            /* clear data */
            mountainArrayList.clear();
            mAdapter.notifyDataSetChanged();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
