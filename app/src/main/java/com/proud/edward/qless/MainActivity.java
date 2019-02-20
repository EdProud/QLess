package com.proud.edward.qless;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

public class MainActivity extends AppCompatActivity implements LocationsAdapter.LocationCallback {

    RecyclerView locationRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locationRecyclerView = (RecyclerView) findViewById(R.id.mainRecyclerView);

        LocationsAdapter locationsAdapter = new LocationsAdapter(new RetrieveLocalLocations().getLocations(), this, this);

        locationRecyclerView.setAdapter(locationsAdapter);
        locationRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public void entryClicked(int id) {
        final Intent intent = new Intent(MainActivity.this, SeatsActivity.class);
        intent.putExtra("locationId", id);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
               startActivity(intent);
            }
        }, 200);

    }
}
