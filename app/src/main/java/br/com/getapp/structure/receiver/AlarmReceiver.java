package br.com.getapp.structure.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.getapp.structure.controller.NotificationAlarm;


/**
 * Created by matheusoliveira on 07/04/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Receiver", "Está recebendo");
        NotificationAlarm noAlarm = new NotificationAlarm();
        noAlarm.createNotification(context);
    }
}
