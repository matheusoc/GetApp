package br.com.getapp.structure.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.getapp.R;
import br.com.getapp.structure.alarmbuild.AlarmBuilder;
import br.com.getapp.structure.controller.DataBase;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.EditAlarmActivity;

/**
 * Created by matheusoliveira on 10/03/2016.
 */
public class AlarmAdapter extends BaseAdapter {

    private final String myAlarm = "AlarmPreferences";

    private Context context;

    private ArrayList<Alarm> alarms;

    private DataBase db;

    public AlarmAdapter(Context context) {
        this.context = context;
        db = new DataBase(context);
        alarms = db.getAllAlarms();
    }
    @Override
    public int getCount() {
        return alarms.size();
    }

    @Override
    public Object getItem(int position) {
        return alarms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final int pos = position;

        final Alarm clock = alarms.get(position);

        String hora;
        String minuto;
        hora = clock.getHora();
        minuto = clock.getMinuto();
        if(Integer.valueOf(hora) >= 0 && Integer.valueOf(hora) <= 9) {
            hora = "0"+hora;
        }
        if(Integer.valueOf(minuto) >= 0 && Integer.valueOf(minuto) <= 9) {
            minuto = "0"+minuto;
        }

        final AlarmBuilder alarmBuilder = new AlarmBuilder(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.alarm_adapter_layout, null);

        TextView tempo = (TextView) layout.findViewById(R.id.tempo);
        tempo.setText(hora + ":" + minuto);

        Switch sw = (Switch) layout.findViewById(R.id.sw);

        Log.i("Está ligado?", String.valueOf(clock.getOn()));
        Log.i("Dia", clock.getDomingo());

        if(clock.getOn() == 1){
            sw.setChecked(true);
        } else {
            sw.setChecked(false);
        }


        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    alarmBuilder.addOneAlarm(clock);
                    clock.setOn(1);
                    db.refresh(clock);
                } else {
                    alarmBuilder.alarmCancel(clock);
                    clock.setOn(0);
                    db.refresh(clock);
                }
            }
        });

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditAlarmActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });

        return layout;
    }

}
