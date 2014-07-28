package com.bloc.blocnotes;

import android.app.FragmentManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
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
            int noteID;

            Intent showNoteIntent = new Intent(context, ShowNoteFragmentIntent.class);

            Intent snoozeReminder = new Intent(context, ShowSnoozeFragment.class);
            snoozeReminder.setAction("SHOW_SNOOZE");

            //Intent dismissIntent = new Intent(context, )

            if(extras.containsKey("NOTE")) {
                notificationText = extras.getString("NOTE");
                snoozeReminder.putExtra("NOTE", extras.getString("NOTE"));
            }
            else {
                notificationText = "A NOTIFICATION WAS TRIGGERED";
            }

            if(extras.containsKey("NOTE_ID")) {
                noteID = extras.getInt("NOTE_ID");
                snoozeReminder.putExtra("NOTE_ID", extras.getInt("NOTE_ID"));
            }
            else {
                noteID = 1;
            }


            //PendingIntent snoozePending = PendingIntent.getBroadcast(context, 0, snoozeReminder, 0);
            PendingIntent snoozePending = PendingIntent.getActivity(context, 0, snoozeReminder, 0);
            PendingIntent showNotePending = PendingIntent.getActivity(context, 0, showNoteIntent, 0);



            builder.setContentText(notificationText);
            builder.setSmallIcon(R.drawable.ic_launcher);
            builder.setContentTitle("My Notification");
            builder.setContentIntent(showNotePending);
            builder.addAction(R.drawable.ic_stat_snooze, "Snooze", snoozePending);
            builder.addAction(R.drawable.ic_stat_dismiss, "Dismiss", snoozePending);

            Notification noteReminderNotification = builder.build();

            NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
            manager.notify(1, noteReminderNotification);
        }
    }
}
