package br.com.getapp.structure.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.getapp.R;
import br.com.getapp.structure.SQL.DataBase;
import br.com.getapp.structure.model.Alarm;

/**
 * Created by User on 16/03/2016.
 */
public class RemoveAlarmActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.removeralarm_layout);

        final Context ctx = this;

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new RemoveAlarmAdapter(this));

    }

    public void refreshList(){
        listView.setAdapter(new RemoveAlarmAdapter(this));
    }

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

            final Alarm clock = alarms.get(position);

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

            ImageButton imageBtn = (ImageButton) layout.findViewById(R.id.imgBtn);
            imageBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db.delete(clock);
                    refreshList();
                }
            });

            return layout;
        }
    }
}


