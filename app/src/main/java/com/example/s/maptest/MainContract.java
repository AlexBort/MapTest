package com.example.s.maptest;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

public interface MainContract {

    interface MainPresenter {
        void clickTrackDistance(Location location, String meters);

      //  LatLng passLatLng(LatLng latLng);
    }

    interface MainView {

    }

    // TODO: 24.08.2018 не знаю, насколько это вообще good practice (наверное лучше все таки использовать handler!!)
//    interface Callback {
//        void f();
//    }
}
