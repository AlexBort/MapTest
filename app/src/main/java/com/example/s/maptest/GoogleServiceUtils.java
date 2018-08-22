package com.example.s.maptest;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class GoogleServiceUtils {


    public static Boolean mLocationPermissionGranted = false;
    private static final String FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;
    private static final String COURSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    public static final int LOCATION_PERMISSION_REQUEST_CODE = 1234;

    public static boolean isGoogleServiceAvailable(Context context) {
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
        if (available == ConnectionResult.SUCCESS)
            return true;
        else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            // FIXME: 21.08.2018 needed to check, does the dialog work correct?!?!
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog((Activity) context, available, 9001);
            dialog.show();
            return false;
        } else {
            Toast.makeText(context, "You can't connect to GoogleService", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    // TODO: 21.08.2018 решить, делать ли метод статическим, или нет?!
    public static void getLocationPermission(Context context) {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */

        // TODO: 21.08.2018 is it good practice: if into if??? (perhaps i should make one if)
        if (ContextCompat.checkSelfPermission(context, FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            if (ContextCompat.checkSelfPermission(context, COURSE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED)
                mLocationPermissionGranted = true;

        } else {
            // FIXME: 21.08.2018 check is activityContext equals not null!
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    LOCATION_PERMISSION_REQUEST_CODE);
        }
    }

    public static void onRequestPermResult(int requestCode, int[] grantResults, SupportMapFragment supportMapFragment,
                                           OnMapReadyCallback readyCallback) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case GoogleServiceUtils.LOCATION_PERMISSION_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            GoogleServiceUtils.mLocationPermissionGranted = false;
                            break;
                        }
                    }
                    GoogleServiceUtils.mLocationPermissionGranted = true;
                    initMap(supportMapFragment, readyCallback);
                }
            }
        }
    }

    public static void initMap(SupportMapFragment supportMapFragment, OnMapReadyCallback readyCallback) {
        //  SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(readyCallback);
    }

}
