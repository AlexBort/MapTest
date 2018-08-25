package com.example.s.maptest;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public interface MainContract {

    interface MainPresenter {
        void clickTrackDistance(Location location, String meters);

        void updateLocation(Location updateLocation);
        //  LatLng passLatLng(LatLng latLng);
    }

    interface MainView {
        void showUpdateLocation();
    }


    interface Callback {
        void callBack(float meters);
    }

}
