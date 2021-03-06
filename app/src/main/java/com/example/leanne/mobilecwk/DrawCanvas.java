package com.example.leanne.mobilecwk;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by leanne on 13/12/2015.
 */
public class DrawCanvas extends Activity{

    //create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ms_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //display options in menu and start activity
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
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

    //declare canvas
    private DrawActivity customCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        //play sound
        MediaPlayer mp = MediaPlayer.create(this, R.raw.bagpipes);
        mp.start();

        //finds canvas in draw activity
        customCanvas = (DrawActivity) findViewById(R.id.signature_canvas);
    }

    //clear canvas
    public void clearCanvas(View v) {
        customCanvas.clearCanvas();
    }
}
