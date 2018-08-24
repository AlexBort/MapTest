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

//    public LatLng passLatLng(LatLng latLng) {
//        return latLng;
//    }

    @Override
    public void clickTrackDistance(Location location, String meters) {

        LatLng latLng = Utils.convertToLatLng(location);
        Toast.makeText(context, meters, Toast.LENGTH_SHORT).show();
        mLocation = location;
        Utils.startService(context);
        // SUCCESS: у меня есть текущая локация!!
        // от это локации считать DISTANCE в любою из сторон!!


     /*   if (checkClick) {
        }*/
        // надо будет понять, какие ВХОДЯЩИЕ ПАРАМЕТРЫ я буду принимать для расчета дистнции
        // для расчета можно использовать еще какой-то Utils
        // здесь же вызовем Service


        //   LatLng latLng = passLatLng(null);

        // вызовем в конце notification
    }

//    private void trackDistance(String metersStr) {
//        int meters = Integer.parseInt(metersStr);
//        LatLng latLng = Utils.convertToLatLng(mLocation);
//        for (int i = 0; i < meters; i++) {
//            latLng++;
//            if (latLng == meters) {
//                Notification
//                return;
//                // TODO: 24.08.2018 СПРОСИТЬ, С ЧЕГО НАЧАТЬ!!!
//            }
//        }
//    }


}
