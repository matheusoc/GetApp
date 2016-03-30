package br.com.getapp.structure.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.getapp.R;
import br.com.getapp.structure.SQL.DataBase;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.EditAlarmActivity;

/**
 * Created by matheusoliveira on 10/03/2016.
 */
public class AlarmAdapter extends BaseAdapter {

    private final String myAlarm = "AlarmPreferences";

    private Context context;

    private ArrayList<Alarm> alarms;

    public AlarmAdapter(Context context) {
        this.context = context;
        DataBase db = new DataBase(context);
        alarms = db.search();
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

        Alarm clock = alarms.get(position);

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

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.alarm_adapter_layout, null);

        TextView tempo = (TextView) layout.findViewById(R.id.tempo);
        tempo.setText(hora + ":" + minuto);

        Switch sw = (Switch) layout.findViewById(R.id.sw);

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditAlarmActivity.class);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });

        return layout;
    }

}
