package com.example.kaltar.project_mama;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BitsListItemFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bits_list_item_fragment);

        Bundle args = new Bundle();
        String searchName= getIntent().getStringExtra("ARG_SEARCH_NAME");
        String searchType= getIntent().getStringExtra("ARG_SEARCH_TYPE");
        String searchFaction= getIntent().getStringExtra("ARG_SEARCH_FACTION");
        args.putString("ARG_SEARCH_NAME", searchName);
        args.putString("ARG_SEARCH_TYPE", searchType);
        args.putString("ARG_SEARCH_FACTION", searchFaction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            BitsItemFragment fragment = new BitsItemFragment();
            fragment.setArguments(args);
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        //}

        //to DO : ajouter le principe des bits ici
        /*mAdapter = new MyBitsItemRecyclerViewAdapter(mValues,mListener );
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClickButtonBitsList(View view) {
        Intent bitsList = new Intent(this, BitsListItemFragment.class);
        startActivity(bitsList);
    }

    public void onClickButtonSearchList(View view) {
        Intent searchBitsList = new Intent(this, BitsListSearch.class);
        startActivity(searchBitsList);
    }

}
