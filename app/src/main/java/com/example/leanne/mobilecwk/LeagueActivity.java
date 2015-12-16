package com.example.leanne.mobilecwk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.example.leanne.mobilecwk.LeagueInfo;

/**
 * Created by leanne on 25/11/2015.
 */
public class LeagueActivity extends Activity implements Serializable{


GridView gridView1;
    LeagueInfo leagueInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league);

       Intent iMainAct = getIntent();

        LeagueInfo TeamInfo = (LeagueInfo) iMainAct.getSerializableExtra("TeamInfo");
    gridView1 = (GridView) findViewById(R.id.gridView1);

        List<LeagueInfo> mylist = new ArrayList<>();



    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.news:
                Intent intent = new Intent(this, NewsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.maps:
                Intent intent2 = new Intent(this, MapActivity.class);
                this.startActivity(intent2);
                break;
            case R.id.league_table:
                Intent intent3 = new Intent(this, LeagueActivity.class);
                this.startActivity(intent3);
                break;
            case R.id.draw:
                Intent intent4 = new Intent(this, DrawCanvas.class);
                this.startActivity(intent4);
                break;
            case R.id.home:
                Intent intent5 = new Intent(this, MainActivity.class);
                this.startActivity(intent5);
                break;

        }
        return true;
    }
}

