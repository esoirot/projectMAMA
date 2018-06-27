package com.example.kaltar.project_mama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BitsCollector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bits_collector);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickButtonBitsList(View view) {
        Intent bitsList = new Intent(this, BitsListItemFragment.class);
        startActivity(bitsList);
    }

    public void onClickButtonBitsFinder(View view) {
        //Intent bitsFinder = new Intent(this, BitsFinder.class);
        //startActivity(bitsFinder);
    }

    public void onClickButtonAddNewBits(View view) {
        //Intent addNewBits = new Intent(this, AddNewBits.class);
        //startActivity(addNewBits);
    }
}
