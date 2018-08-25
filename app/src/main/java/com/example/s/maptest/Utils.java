package com.example.s.maptest;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
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

    public static void startService(Context context) {
        Intent intentService = new Intent(context, DistanceService.class);
        intentService.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        context.startService(intentService);
    }

    public static Notification createNotification(Context context, String title, String description, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Notification notification = builder.
                setContentTitle(title).
                setContentText(description).
                setTicker(" ").
                setSmallIcon(R.mipmap.ic_launcher).
                setAutoCancel(true).
                setContentIntent(pendingIntent).build();
        return notification;
    }

}
