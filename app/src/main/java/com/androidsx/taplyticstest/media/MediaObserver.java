package com.androidsx.taplyticstest.media;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;

public class MediaObserver extends ContentObserver {
    private Handler responseHandler;
    private Uri uri;

    public MediaObserver(Uri uri, Handler responseHandler) {
        super(responseHandler);
        this.uri = uri;
        this.responseHandler = responseHandler;
    }

    public void register(Context context) {
        context.getContentResolver().registerContentObserver(uri, true, this);
    }

    public void unRegister(Context context) {
        context.getContentResolver().unregisterContentObserver(this);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        if (this.uri.equals(uri)) { // This is for prevent other media changes. Only new media will be notified.
            responseHandler.sendMessage(Message.obtain());
        }
    }
}
