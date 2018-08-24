package com.example.s.maptest;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

public class App extends Application {

    private static Context context;
    public static final String SERVICE_ID = "exampleService";

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getGlobalContext() {
        return context;
    }

    public static Resources getAppResources() {
        return context.getResources();
    }

//    private void createNotificationChannel() {
//
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
//
//        Notification notification = builder.
//                setContentTitle("title").
//                setContentText("content text ").
//                setAutoCancel(true).
//                setContentIntent(pendingIntent).build();
//
//        ContextCompat.startForegroundService();
//    }

}
