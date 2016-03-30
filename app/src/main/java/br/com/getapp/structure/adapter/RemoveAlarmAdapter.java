package br.com.getapp.structure.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.getapp.R;
import br.com.getapp.structure.SQL.DataBase;
import br.com.getapp.structure.model.Alarm;

/**
 * Created by User on 19/03/2016.
 */
public class RemoveAlarmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Alarm> alarms;
    private DataBase db;

    public RemoveAlarmAdapter (Context context) {
        this.context = context;
        this.db = new DataBase(context);
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        Alarm clock = alarms.get(position);

        final DataBase bd = db;

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
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layout = inflater.inflate(R.layout.removeralarm_adapter_layout, null);

        TextView tempo = (TextView) layout.findViewById(R.id.temp);
        tempo.setText(hora + ":" + minuto);

        return layout;
    }
}
