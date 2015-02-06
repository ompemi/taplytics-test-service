package com.androidsx.taplyticstest.media;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;

import com.androidsx.taplyticstest.NotificationHelper;

import java.util.ArrayList;
import java.util.List;

public class MediaObserversManager {
    private List<MediaObserver> mediaObservers = new ArrayList<>();
    private Context context;

    public MediaObserversManager(Context context) {
        this.context = context;
        mediaObservers.add(new MediaObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, responseHandler));
        mediaObservers.add(new MediaObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, responseHandler));
    }

    public void onStart() {
        for (MediaObserver m : mediaObservers) {
            m.register(context);
        }
    }

    public void onDestroy() {
        for (MediaObserver m : mediaObservers) {
            m.unRegister(context);
        }
    }

    Handler responseHandler = new Handler() {
        public void handleMessage(Message msg) {
            Log.i("YAY", "New image");
            NotificationHelper.showNotificationOnNewMedia(context);
        }
    };

}
