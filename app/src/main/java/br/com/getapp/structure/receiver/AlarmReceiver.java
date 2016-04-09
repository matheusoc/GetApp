package br.com.getapp.structure.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import br.com.getapp.structure.controller.DataBase;
import br.com.getapp.structure.controller.NotificationAlarm;
import br.com.getapp.structure.model.Alarm;


/**
 * Created by matheusoliveira on 07/04/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Receiver", "Está recebendo");
        DataBase db = new DataBase(context);
        int id = intent.getIntExtra("id", -1);
        Alarm alarm = db.search(id);
        alarm.setOn(0);
        db.refresh(alarm);
        NotificationAlarm.createNotification(context, alarm);
    }
}
