package com.androidsx.taplyticstest.media.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.androidsx.taplyticstest.media.MediaObserversManager;

public class MediaListenerService extends Service {
    private MediaObserversManager mediaManager;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaManager = new MediaObserversManager(this);
        mediaManager.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaManager.onDestroy();
    }
}
