package br.com.getapp.structure.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import br.com.getapp.R;
import br.com.getapp.structure.adapter.RemoveAlarmAdapter;

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
}
