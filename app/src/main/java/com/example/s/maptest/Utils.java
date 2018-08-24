package com.example.s.maptest;

import android.location.Location;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;

public class Utils {

    public static void makeSnackbar(View rootView, String message) {
        Snackbar.make(rootView,
                message, Snackbar.LENGTH_LONG).show();
    }

    public static LatLng convertToLatLng(Location location) {
        return new LatLng(location.getLatitude(), location.getLongitude());
    }

}
