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

        listView = (ListView) findViewById(R.id.listView2);
        listView.setAdapter(new RemoveAlarmAdapter(this));

    }

    public void refreshList() {
        listView.setAdapter(new RemoveAlarmAdapter(this));
    }

    public class RemoveAlarmAdapter extends BaseAdapter{

        private Context context;
        private ArrayList<Alarm> alarms;

        RemoveAlarmAdapter(Context context) {
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
            final DataBase db = new DataBase(context);

            final Alarm clock = alarms.get(position);

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.removeralarm_adapter_layout, null);

            ImageButton imgBtn = (ImageButton) layout.findViewById(R.id.removeImageButton);
            imgBtn.setOnClickListener(new View.OnClickListener() {
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
