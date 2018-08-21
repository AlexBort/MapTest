package com.example.s.maptest;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MainActivity extends AppCompatActivity implements MainView, OnMapReadyCallback {

    private static final String TAG = "MainActivity";
    private GoogleMap mGoogleMap;
    private MainPresenterImpl mainPresenter;
    private SupportMapFragment supportMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (GooglePlayUtils.isGoogleServiceAvailable(this)) {
            GooglePlayUtils.getLocationPermission(this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        GooglePlayUtils.onRequestPermResult(requestCode, grantResults, supportMapFragment, this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;
    }


}
