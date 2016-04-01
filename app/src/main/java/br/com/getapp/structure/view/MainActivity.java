package br.com.getapp.structure.view;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextClock;

import br.com.getapp.R;
import br.com.getapp.structure.adapter.AlarmAdapter;
import br.com.getapp.structure.controller.CallTimePicker;

/**
 * Created by matheusoliveira on 08/03/2016.
 */
public class MainActivity extends AppCompatActivity {

    private TextClock txtClock;
    private FloatingActionButton fab;
    private ListView listView;
    private ImageButton imgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        txtClock = (TextClock) findViewById(R.id.textClock);
        txtClock.setFormat24Hour(txtClock.getFormat24Hour());

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, EditAlarmActivity.class);
                i.putExtra("position", position);
                startActivity(i);
            }
        });
        listView.setAdapter(new AlarmAdapter(this));

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment newFragment = new CallTimePicker();
                newFragment.show(getFragmentManager(), "Start");
            }
        });

        imgButton = (ImageButton) findViewById(R.id.imgButton);
        imgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, RemoveAlarmActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        refreshList();
    }

    public void refreshList() {
        listView.setAdapter(new AlarmAdapter(this));
    }
}
