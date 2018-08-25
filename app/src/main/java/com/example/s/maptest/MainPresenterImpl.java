package com.example.s.maptest;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class MainPresenterImpl implements MainContract.MainPresenter {

    private static final String TAG = "MainPresenterImpl";
    private MainContract.MainView mainView;
    private Context context;
    private Location mLocation;


    public MainPresenterImpl() {

    }


    public MainPresenterImpl(MainContract.MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    public MainPresenterImpl(Context context) {
        this.context = context;
    }


    @Override
    public void clickTrackDistance(Location location, String meters) {

        LatLng latLng = Utils.convertToLatLng(location);
        //   Toast.makeText(context, meters, Toast.LENGTH_SHORT).show();
        mLocation = location;
        Utils.startService(context, Float.parseFloat(meters));

    }

    @Override
    public void updateLocation(Location updateLocation) {
        mainView.showUpdateLocation();
    }


}
