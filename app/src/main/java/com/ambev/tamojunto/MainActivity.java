package com.ambev.tamojunto;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ambev.tamojunto.R;
import com.ambev.tamojunto.helper.GPSTracker;
import com.ambev.tamojunto.model.Service;
import com.ambev.tamojunto.utils.AddActivityPermissionsDispatcher;
import com.ambev.tamojunto.webservice.APIClient;
import com.ambev.tamojunto.webservice.APIInterface;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;

import permissions.dispatcher.NeedsPermission;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity
        implements OnMapReadyCallback, NavigationView.OnNavigationItemSelectedListener {

    private Call<ArrayList<Service>> callServices;
    private APIInterface apiService;


    private GoogleMap mMap;
    private GPSTracker gps;
    private double latitude = 0f, longitude = 0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AddActivityPermissionsDispatcher.getLatLngWithCheck(MainActivity.this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.rapel) {
            return true;
        } else  if (id == R.id.surfar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MainActivity.this, MySchedulesActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    GoogleMap googleMapExt;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        googleMapExt = googleMap;

        AddActivityPermissionsDispatcher.getLatLngWithCheck(MainActivity.this);

        LatLng sydney = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        apiService = APIClient.getService().create(APIInterface.class);
        callServices = apiService.getServicos();

        callServices.enqueue(new Callback<ArrayList<Service>>() {
            @Override
            public void onResponse(Call<ArrayList<Service>> call, Response<ArrayList<Service>> response) {

                ArrayList<Service> srvcs = response.body();


                ArrayList<Service> services = new ArrayList<Service>();

                services.addAll(srvcs);

                for (Service service : services) {
                    LatLng latLng = new LatLng(Double.parseDouble(service.getLatitude()), Double.parseDouble(service.getLongitude()));
                    mMap.addMarker(new MarkerOptions().position(latLng).title(String.valueOf(service.getId())).icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons("icon_marker",90,120))));
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                    googleMapExt.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,10));
                    googleMapExt.animateCamera(CameraUpdateFactory.zoomIn());
                    googleMapExt.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);

                    mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                    {

                        @Override
                        public boolean onMarkerClick(Marker arg0) {
                            Intent intent = new Intent(MainActivity.this, InfoServiceActivity.class);
                            intent.putExtra("id", "" + arg0.getTitle());
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);

                            return true;
                        }

                    });
                }

            }

            @Override
            public void onFailure(Call<ArrayList<Service>> call, Throwable t) {
                Log.e("Networking", t.toString());

            }
        });
    }

    public Bitmap resizeMapIcons(String iconName, int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }

    @NeedsPermission(Manifest.permission.ACCESS_FINE_LOCATION)
    public void getLatLng(){
        gps = new GPSTracker(MainActivity.this);
        latitude = gps.getLatitude();
        longitude = gps.getLongitude();
    }
}
