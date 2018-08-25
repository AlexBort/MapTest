package com.example.s.maptest;

import android.content.Context;
import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public interface MainContract {

    interface MainPresenter {
        void clickTrackDistance(Location location, String meters, Context context);

        void updateLocation(Location updateLocation, String check);

        void setMainView(MainView mainView);
        //  LatLng passLatLng(LatLng latLng);
    }

    interface MainView {
        void showUpdateLocation(String message);
    }


    interface Callback {
        void callBack(float meters);
    }

}
