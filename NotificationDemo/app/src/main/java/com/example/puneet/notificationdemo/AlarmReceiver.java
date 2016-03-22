package com.example.puneet.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.support.v4.app.NotificationCompat;

/**
 * Created by puneet on 3/21/16.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, MainActivity.class);

        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addParentStack(MainActivity.class);
        taskStackBuilder.addNextIntent(intent1);

        PendingIntent pendingIntent = taskStackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Notification notification = builder.setContentTitle("Notification")
                                            .setContentText("New voicemail notification")
                                            .setContentIntent(pendingIntent)
                                            .setSmallIcon(R.mipmap.ic_launcher)
                                            .build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notification);
    }
}
