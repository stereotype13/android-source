package com.bloc.blocnotes;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by rhodel on 7/22/2014.
 */
public class NoteReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals("SHOW_NOTIFICATION")) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

            Bundle extras = intent.getExtras();
            String notificationText;

            if(extras.containsKey("NOTE")) {
                notificationText = extras.getString("NOTE");
            }
            else {
                notificationText = "A NOTIFICATION WAS TRIGGERED";
            }

            builder.setContentText(notificationText);
            builder.setSmallIcon(R.drawable.fancy_button);
            builder.setContentTitle("My Notification");

            Notification noteReminderNotification = builder.build();

            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(1, noteReminderNotification);
        }
    }
}
