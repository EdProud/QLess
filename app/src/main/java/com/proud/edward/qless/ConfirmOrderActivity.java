package com.proud.edward.qless;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ConfirmOrderActivity extends AppCompatActivity implements MenuAdapter.MenuCallback{

    private RecyclerView menuRecyclerView;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Confirm Order");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder d = new AlertDialog.Builder(ConfirmOrderActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                d.setTitle("Order Confirmed");
                d.setMessage("Please pick up your food from the Pie Shop at gate 2 in 10 minutes.\nThank you.");

                d.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(ConfirmOrderActivity.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = d.create();
                alertDialog.show();
            }
        });

        menuRecyclerView = (RecyclerView) findViewById(R.id.orderRecyclerView);

        ArrayList<MenuItemModel> orders = getIntent().getParcelableArrayListExtra("orders");
        menuAdapter = new MenuAdapter(orders, this, false);

        menuRecyclerView.setAdapter(menuAdapter);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.blocker).bringToFront();

        double total = getIntent().getDoubleExtra("price", 0);

        DecimalFormat df = new DecimalFormat("#0.00");
        ((TextView)findViewById(R.id.orderTotalTextView)).setText("£" + df.format(total));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void ordersChanged() {

    }
}
