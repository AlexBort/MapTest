package com.example.s.maptest;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

public class MainPresenterImpl implements MainContract.MainPresenter {

    private static final String TAG = "MainPresenterImpl";
    private MainContract.MainView mMainView;
    private Context context;
    private Location mLocation;
    private static MainPresenterImpl presenter = new MainPresenterImpl();


    private MainPresenterImpl() {

    }

    // TODO: 26.08.2018 сделать его потокобезопасным
    public static MainPresenterImpl getPresenter() {
        return presenter;
    }


//    public MainPresenterImpl(MainContract.MainView mainView, Context context) {
//        this.mainView = mainView;
//        this.context = context;
//    }
//
//    public MainPresenterImpl(MainContract.MainView mainView) {
//        this.mainView = mainView;
//    }
//
//    public MainPresenterImpl(Context context) {
//        this.context = context;
//    }


    @Override
    public void clickTrackDistance(Location location, String meters, Context context) {

        LatLng latLng = Utils.convertToLatLng(location);
        //   Toast.makeText(context, meters, Toast.LENGTH_SHORT).show();
        mLocation = location;
        Utils.startService(context, Float.parseFloat(meters));

    }

    @Override
    public void updateLocation(Location updateLocation, String check) {
        mMainView.showUpdateLocation(check);
    }

    @Override
    public void setMainView(MainContract.MainView mainView) {
        mMainView = mainView;
    }


}
