package com.example.s.maptest;

import android.support.design.widget.Snackbar;
import android.view.View;

public class Utils {

    public static void makeSnackbar(View rootView, String message) {
        Snackbar.make(rootView,
                message, Snackbar.LENGTH_LONG).show();
    }

}
