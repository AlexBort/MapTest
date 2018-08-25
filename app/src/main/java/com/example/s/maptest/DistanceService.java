package com.example.s.maptest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
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
    int temp = 0;


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

//            temp++;
//            if (temp == 1)
//                Toast.makeText(this, "Service Started!", Toast.LENGTH_SHORT).show();

            showNotification();

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

        Notification notification = Utils.createNotification(this, Constants.TITLE_NOTIF, Constants.DESCRIP_NOTIF, pendingIntent);

        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE,
                notification);

        // TODO: 25.08.2018 потом убрать этот Thread sleep!
        // could work after the killing app
        try {
            Thread.sleep(10000);
            Log.e(TAG, "showNotification: " + "service goes on...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        // TODO: 25.08.2018 это когда мы посчитаем необходимое нам расстояние
//        Notification notifResult = Utils.createNotification(this, Constants.TITLE_NOTIF, Constants.DESCRIP_NOTIF, pendingIntent);
//        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
//        notificationManager.notify(0, notifResult);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // TODO: 25.08.2018  надо понять, надо ли оно здесь
        //    stopSelf();
    }

}
