package br.com.getapp.structure.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.getapp.R;
import br.com.getapp.structure.alarmbuild.AlarmBuilder;
import br.com.getapp.structure.controller.DataBase;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.EditAlarmActivity;
import br.com.getapp.structure.view.AlarmHolder;

/**
 * Created by matheusoliveira on 10/03/2016.
 */
public class AlarmAdapter extends RecyclerView.Adapter {

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.alarm_adapter_layout, null);

        AlarmHolder viewHolder = new AlarmHolder(layout);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        final Alarm clock = alarms.get(position);
        final int pos = position;

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

        TextView tempo = (TextView) holder.itemView.findViewById(R.id.tempo);

        Switch sw = (Switch) holder.itemView.findViewById(R.id.sw);

        tempo.setText(hora + ":" + minuto);

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

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, EditAlarmActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("position", pos);
                context.startActivity(i);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return alarms.size();
    }

}
