package br.com.getapp.structure.controller;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import br.com.getapp.R;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.MainActivity;

/**
 * Created by matheusoliveira on 07/04/2016.
 */
public abstract class NotificationAlarm {


    public static void createNotification(Context context, Alarm alarm){
        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context,
                (int) System.currentTimeMillis(), intent, 0);

        NotificationCompat.Builder noBuilder = new NotificationCompat.Builder(context)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setContentTitle("Alarm")
                .setContentText(alarm.getHora()+":"+alarm.getMinuto())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setSmallIcon(R.drawable.ic_action_name)
                .setColor(context.getResources().getColor(R.color.colorClock))
                .setVibrate(new long[0])
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(context.NOTIFICATION_SERVICE);

        Toast.makeText(context, "Funfa", Toast.LENGTH_SHORT).show();

        notificationManager.notify(0, noBuilder.build());
    }
}
