package com.proud.edward.qless;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

public class SeatsActivity extends AppCompatActivity {

    private String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seats);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("St. James'");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SeatsActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        Button seatButton = (Button)findViewById(R.id.seatButton);
        seatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog((Button)v, false, "Select seat number");
            }
        });
        Button rowButton = (Button)findViewById(R.id.rowButton);
        rowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog((Button)v, true, "Select row letter");
            }
        });
        Button gateButton = (Button)findViewById(R.id.gateButton);
        gateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog((Button) v, false, "Select gate");
            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showDialog(final Button v, final boolean isAlphabet, String title){
        final AlertDialog.Builder d = new AlertDialog.Builder(SeatsActivity.this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.number_picker_dialog, null);
        d.setTitle(title);
        d.setView(dialogView);
        final NumberPicker numberPicker = (NumberPicker) dialogView.findViewById(R.id.numberPicker2);
        if (!isAlphabet){
            numberPicker.setMaxValue(100);
            numberPicker.setMinValue(1);
        } else {

            numberPicker.setMaxValue(0);
            numberPicker.setMaxValue(23);
            numberPicker.setDisplayedValues(alphabet);
        }
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Log.d("saf", "onValueChange: ");
            }
        });
        d.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("fgdfa", "onClick: " + numberPicker.getValue());
                String toDisplay;
                int pickerValue = numberPicker.getValue();
                if (isAlphabet){
                    toDisplay = alphabet[pickerValue];
                } else {
                    toDisplay = String.valueOf(pickerValue);
                }
                v.setText(toDisplay);
            }
        });
        d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AlertDialog alertDialog = d.create();
        alertDialog.show();
    }

}
