package com.androidsx.taplyticstest;

import android.app.Application;

import com.taplytics.sdk.Taplytics;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Taplytics.startTaplytics(this, "58513c85ee6c1b60d79e58a8d33099db6225e23f");
    }
}