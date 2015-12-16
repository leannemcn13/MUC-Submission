package com.example.leanne.mobilecwk;

import android.annotation.SuppressLint;
import android.app.Activity;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by leanne on 25/11/2015.
 */
public class NewsActivity extends AppCompatActivity {

    //create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ms_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //display options in menu and start activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.news:
                Intent intent = new Intent(this, NewsActivity.class);
                this.startActivity(intent);
                finish();
                break;
            case R.id.maps:
                Intent intent2 = new Intent(this, MapActivity.class);
                this.startActivity(intent2);
                finish();
                break;
            case R.id.league_table:
                Intent intent3 = new Intent(this, LeagueActivity.class);
                this.startActivity(intent3);
                finish();
                break;
            case R.id.draw:
                Intent intent4 = new Intent(this, DrawCanvas.class);
                this.startActivity(intent4);
                finish();
                break;
            case R.id.home:
                Intent intent5 = new Intent(this, MainActivity.class);
                this.startActivity(intent5);
                finish();
                break;

        }
        return true;
    }


    // A reference to the local object
    private NewsActivity local;

    //delcare url for RSS feed
    String myurl = "http://feeds.bbci.co.uk/sport/0/football/scottish/rss.xml";

    /**
     * This method creates main application view
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set view
        setContentView(R.layout.activity_news);
        ListView items = (ListView) findViewById(R.id.newsItemText);
        StrictMode.ThreadPolicy policy =
                new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);



        // Set reference to this activity
        local = this;
        try {
            // Create RSS reader

            RssReader rssReader = new RssReader(myurl);

            // Parse RSS, get items
            List<RSSItem> mylist = new ArrayList<>();
            mylist = rssReader.getItems();
            ArrayAdapter<RSSItem> adapter = new ArrayAdapter<RSSItem>(local, android.R.layout.simple_list_item_1, mylist);
            // Set list adapter for the ListView
            items.setAdapter(adapter);

        } catch (Exception e) {
            Log.e("RssReader", e.getMessage());
        }




    }




}

