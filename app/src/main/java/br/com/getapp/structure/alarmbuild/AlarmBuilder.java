package br.com.getapp.structure.alarmbuild;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

import br.com.getapp.structure.receiver.AlarmReceiver;
import br.com.getapp.structure.model.Alarm;

/**
 * Created by User on 01/04/2016.
 */
public class AlarmBuilder {

    private  Intent i;
    private  PendingIntent p;
    private  AlarmManager alarmManager;
    private  Context context;

    public AlarmBuilder(Context context) {
        this.context = context;
        alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
    }

    public  void addOneAlarm(Alarm alarm) {
        i = new Intent(context, AlarmReceiver.class);
        i.putExtra("id", alarm.getID());
        p = PendingIntent.getBroadcast(context, alarm.getID(), i, 0);
        Log.i("Alarm ID", String.valueOf(alarm.getID()));
        Long time;
        time = getTimeToAlarm(alarm);
        Log.i("Time", String.valueOf(time));
        alarmManager.set(AlarmManager.RTC_WAKEUP, time, p);
    }

    private  Long getTimeToAlarm(Alarm alarm) {
        Long time;
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.SECOND, 0);

        int hourToSet = Integer.parseInt(alarm.getHora());
        int minuteToSet = Integer.parseInt(alarm.getMinuto());

        Log.i("hora do dia", String.valueOf(hour));
        Log.i("Minuto do dia", String.valueOf(minute));
        Log.i("hora set do dia", String.valueOf(hourToSet));
        Log.i("Minuto set do dia", String.valueOf(minuteToSet));
        if(hour >= hourToSet && minute >= minuteToSet ) {

            c1.set(Calendar.DAY_OF_YEAR, c1.get(Calendar.DAY_OF_YEAR)+1);
            c1.set(Calendar.HOUR_OF_DAY, hourToSet);
            c1.set(Calendar.MINUTE, minuteToSet);
            time = (c1.getTimeInMillis());
            Log.i("Hora maior,minuto menor", "hey");
        } else if(hour > hourToSet) {
            c1.set(Calendar.DAY_OF_YEAR, c1.get(Calendar.DAY_OF_YEAR)+1);
            c1.set(Calendar.HOUR_OF_DAY, hourToSet);
            c1.set(Calendar.MINUTE, minuteToSet);
            time = (c1.getTimeInMillis());
            Log.i("Hora maior" , "hey");
        } else {
            c1.set(Calendar.HOUR_OF_DAY, hourToSet);
            c1.set(Calendar.MINUTE, minuteToSet);
            time = (c1.getTimeInMillis());
            Log.i("Normal", "hey");
        }

        return time;
    }

    public void alarmCancel(Alarm alarm) {
        Log.i("Alarm ID", String.valueOf(alarm.getID()));
        i = new Intent(context, AlarmReceiver.class);
        p = PendingIntent.getBroadcast(context, alarm.getID(), i, 0);
        alarmManager.cancel(p);

    }

}
