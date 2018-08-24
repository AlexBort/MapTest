package com.example.s.maptest;

public interface Variables {

   // String snackMessage = App.getAppResources().getString(R.string.snackbar_text);  // snackbar_text
   String snackMessage = App.getGlobalContext().getResources().getString(R.string.snackbar_text);
}
