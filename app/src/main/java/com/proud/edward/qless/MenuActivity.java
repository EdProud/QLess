package com.proud.edward.qless;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements MenuAdapter.MenuCallback {

    private RecyclerView menuRecyclerView;
    private MenuAdapter menuAdapter;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("St. James'");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, ConfirmOrderActivity.class);
                intent.putExtra("orders", menuAdapter.getOrders());
                intent.putExtra("price", total);
                startActivity(intent);

            }
        });

        menuRecyclerView = (RecyclerView) findViewById(R.id.menuRecyclerView);

        menuAdapter = new MenuAdapter(new LocalMenu().getMenu(), this, true);

        menuRecyclerView.setAdapter(menuAdapter);
        menuRecyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        ArrayList<MenuItemModel> orders = menuAdapter.getOrders();
        TextView ordersTextView = (TextView) findViewById(R.id.totalTextView);
        int numberOfItems = 0;
        total = 0;
        if (!orders.isEmpty()) {
            for (MenuItemModel order : orders) {
                int numberOfThisItem = order.getAmountOrdered();
                numberOfItems += numberOfThisItem;
                total += order.getPrice() * numberOfThisItem;
            }
        }
        DecimalFormat df = new DecimalFormat("#0.00");
        ordersTextView.setText(numberOfItems + " items: £" + df.format(total));

    }

}
