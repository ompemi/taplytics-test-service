package com.androidsx.taplyticstest;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;


public class NotificationHelper {

    public static final int NEW_MEDIA_NOTIFICATION_ID = 11;

    public static void showNotificationOnNewMedia(Context context) {
        Bitmap bigPicture = BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_launcher);

        NotificationCompat.BigPictureStyle notiStyle = new NotificationCompat.BigPictureStyle();
        notiStyle.setBigContentTitle("New image");
        notiStyle.setSummaryText("Yeah, new image");

        Intent viewIntent = new Intent(context, MainActivity.class);
        viewIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 1001, viewIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        pendingIntent.cancel();

        // then we do it again
        Intent viewIntent2 = new Intent(context, MainActivity.class);
        viewIntent2.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntentForReal = PendingIntent.getActivity(context, 1001, viewIntent2, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setLargeIcon(bigPicture)
                        .setAutoCancel(true)
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bigPicture))
                        .setContentTitle("New image")
                        .setContentText("Oh lala")
                        .setContentIntent(pendingIntentForReal)
                        .setAutoCancel(true);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(NEW_MEDIA_NOTIFICATION_ID, notificationBuilder.build());
    }
}
