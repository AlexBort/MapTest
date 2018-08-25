package com.example.s.maptest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.widget.Toast;

import fr.quentinklein.slt.LocationTracker;

public class DistanceTask extends AsyncTask<Void, Void, Void> {

    private float meters;

    // TODO: 26.08.2018 что-то придумать, чтобы не было утечки памяти!!
    private Context context;
    private Location mLocation;

    public DistanceTask(Context context, float meters) {
        this.context = context;
        this.meters = meters;
    }


    @SuppressLint("MissingPermission")
    @Override
    protected Void doInBackground(Void... voids) {

        LocationTracker tracker = new LocationTracker(context, Utils.getTrackerSettings(meters)) {
            @Override
            public void onLocationFound(@NonNull Location location) {
                // TODO: 26.08.2018 ПЕРЕДАТЬ НОВУЮ ЛОКАЦИЮ В MAIN_ACTIVITY - отобразить ее на карте!!
                // и начать расчет дистанции с новой локации!!
                mLocation = location;
            }

            @Override
            public void onTimeout() {

            }
        };

        tracker.startListening();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        MainPresenterImpl presenter = new MainPresenterImpl();
        presenter.updateLocation(mLocation);

    }


}
