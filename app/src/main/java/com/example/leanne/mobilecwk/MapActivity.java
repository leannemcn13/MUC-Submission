package com.example.leanne.mobilecwk;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    //display menu
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

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * I have added 4 markers to football club grounds.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in celtic park and move the camera
        LatLng celtic = new LatLng(55.849554, -4.205543);
        mMap.addMarker(new MarkerOptions().position(celtic).title("Celtic FC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(celtic));

        // Add a marker in aberdeen football stadium and move the camera
        LatLng aberdeen = new LatLng(57.159851, -2.088549);
        mMap.addMarker(new MarkerOptions().position(aberdeen).title("Aberdeen FC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aberdeen));

        // Add a marker in St Johnstone football stadium and move the camera
        LatLng stJon = new LatLng(56.407158, -3.482180);
        mMap.addMarker(new MarkerOptions().position(stJon).title("St Johnstone FC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(stJon));

        // Add a marker in Hearts football stadium and move the camera
        LatLng hearts = new LatLng(55.909849, -3.318308);
        mMap.addMarker(new MarkerOptions().position(hearts).title("Hearts FC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(hearts));
    }
}
