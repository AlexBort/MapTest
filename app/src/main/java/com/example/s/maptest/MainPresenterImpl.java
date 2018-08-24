package com.example.s.maptest;

import android.content.Context;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

public class MainPresenterImpl implements MainContract.MainPresenter {

    private static final String TAG = "MainPresenterImpl";
    private MainContract.MainView mainView;
    private Context context;


    public MainPresenterImpl(MainContract.MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    public MainPresenterImpl() {

    }

//    public LatLng passLatLng(LatLng latLng) {
//        return latLng;
//    }

    @Override
    public void trackDistance(Location location) {
        Log.e(TAG, "track latitude: " + String.valueOf(location.getLatitude()));
     /*   if (checkClick) {
        }*/
        // надо будет понять, какие ВХОДЯЩИЕ ПАРАМЕТРЫ я буду принимать для расчета дистнции
        // для расчета можно использовать еще какой-то Utils
        // здесь же вызовем Service


        //   LatLng latLng = passLatLng(null);

        // вызовем в конце notification
    }

    @Override
    public LatLng passLatLng(LatLng latLng) {
        return null;
    }
}
