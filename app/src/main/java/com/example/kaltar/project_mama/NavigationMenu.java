package com.example.kaltar.project_mama;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;


public class NavigationMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_bit_collec) {
            Intent bitsCollector = new Intent(this, BitsCollector.class);
            startActivity(bitsCollector);
            // Handle the camera action
        } else if (id == R.id.nav_army_creator) {
            Intent armyCreator = new Intent(this, ArmyCreator.class);
            startActivity(armyCreator);
        } else if (id == R.id.nav_wargaming) {
            Intent wargaming = new Intent(this, Wargaming.class);
            startActivity(wargaming);
        } else if (id == R.id.nav_hobbying) {
            Intent hobbying = new Intent(this, Hobbying.class);
            startActivity(hobbying);
        } else if (id == R.id.nav_news_feed) {
            Intent newsFeed = new Intent(this, NewsFeedMenu.class);
            startActivity(newsFeed);
        } else if (id == R.id.nav_settings) {
            Intent setting = new Intent(this, SettingsActivity.class);
            startActivity(setting);
        } else if (id == R.id.nav_about_us) {
            Intent aboutUs = new Intent(this, AboutUs.class);
            startActivity(aboutUs);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void OnClickButtonBitsCollector(View view) {
        Intent bitsCollector = new Intent(this, BitsCollector.class);
        startActivity(bitsCollector);
    }

    public void onClickArmyCreator(View view) {
        Intent armyCreator = new Intent(this, ArmyCreator.class);
        startActivity(armyCreator);
    }

    public void onClickWargaming(View view) {
        Intent wargaming = new Intent(this, Wargaming.class);
        startActivity(wargaming);
    }

    public void onClickHobbying(View view) {
        Intent hobbying = new Intent(this, Hobbying.class);
        startActivity(hobbying);
    }

    public void onClickNewsFeed(View view) {
        Intent newsFeed = new Intent(this, NewsFeedMenu.class);
        startActivity(newsFeed);
    }
}
