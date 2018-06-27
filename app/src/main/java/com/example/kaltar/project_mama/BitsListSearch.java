package com.example.kaltar.project_mama;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class BitsListSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bits_list_search);
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

    public void onClickButtonSearchList(View view) {
        Intent searchBitsList = new Intent(this, BitsListSearch.class);
        startActivity(searchBitsList);
    }

    public void onClickButtonDoSearchList(View view) {
        Intent bitsList = new Intent(this, BitsListItemFragment.class);

        final EditText nameField = (EditText) findViewById(R.id.EditTextName);
        String name = nameField.getText().toString();

        final Spinner typeSpinner = (Spinner) findViewById(R.id.SpinnerBitType);
        String bit_type = typeSpinner.getSelectedItem().toString();

        final Spinner factionSpinner = (Spinner) findViewById(R.id.SpinnerBitFaction);
        String bit_faction = factionSpinner.getSelectedItem().toString();

        bitsList.putExtra("ARG_SEARCH_NAME", name);
        bitsList.putExtra("ARG_SEARCH_TYPE", bit_type);
        bitsList.putExtra("ARG_SEARCH_FACTION", bit_faction);
        startActivity(bitsList);
    }
}
