package com.example.s.maptest.mvp;

import com.example.s.maptest.MainContract;

public class MainPresenterImpl {

    private MainContract.MainView mainView;

    public MainPresenterImpl(MainContract.MainView mainView) {
        this.mainView = mainView;
    }


    public void initMap() {
   //     mainView.initMap();
    }
}
