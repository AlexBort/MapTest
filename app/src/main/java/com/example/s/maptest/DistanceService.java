package com.example.s.maptest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

public class DistanceService extends Service {

    private static final int PERM_REQUEST_LOCATION = 1;
    private static final String TAG = "DistanceService";
    public static final int RESULT_OK = -1;
    public static final String KEY_MESSAGE = "KEY_MESSAGE";
    public static final String KEY_RECEIVER = "KEY_RECEIVER";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "onBind Called", Toast.LENGTH_SHORT).show();
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public DistanceService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: " + "onStartCommand");
        if (intent.getAction().equals(Constants.ACTION.STARTFOREGROUND_ACTION)) {
            Log.e(TAG, "onStartCommand: " + "Received Start Foreground Intent");

            showNotification();
            Toast.makeText(this, "Service Started!", Toast.LENGTH_SHORT).show();

        } else if (intent.getAction().equals(
                Constants.ACTION.STOPFOREGROUND_ACTION)) {
            Log.e(TAG, "onStartCommand: " + "Received Stop Foreground Intent");

            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }

    private void showNotification() {

        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getService(this, 0,
                notificationIntent, 0);



        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("title")
                .setTicker("ticker")
                .setContentText("Content text")
                .setContentIntent(pendingIntent)
                .setOngoing(true)
                /*.addAction(android.R.drawable.ic_menu_close_clear_cancel,"close", buttonClosePendingIntent)*/
                .build();

        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                notification);

        // could work after the killing app
        try {
            Thread.sleep(10000);
            Log.e(TAG, "showNotification: " + "service goes on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        Notification notification_ = builder.
                setContentTitle("new title").
                setContentText("new content").
                setTicker("New Message Alert").
                setSmallIcon(R.mipmap.ic_launcher).
                setAutoCancel(true).
                setContentIntent(pendingIntent).build();

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification_);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // TODO: 25.08.2018  надо понять, надо ли оно здесь
        //    stopSelf();
    }

}
