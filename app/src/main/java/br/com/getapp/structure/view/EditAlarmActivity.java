package br.com.getapp.structure.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


import br.com.getapp.R;

/**
 * Created by matheusoliveira on 09/03/2016.
 */
public class EditAlarmActivity extends AppCompatActivity {

    private final String myAlarm = "AlarmPreferences";

    private CheckBox segundaSW;
    private CheckBox tercaSW;
    private CheckBox quartaSW;
    private CheckBox quintaSW;
    private CheckBox sextaSW;
    private CheckBox sabadoSW;
    private CheckBox domingoSW;

    private Button confirmBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editalarm_layout);

        segundaSW = (CheckBox) findViewById(R.id.segundaSW);
        tercaSW = (CheckBox) findViewById(R.id.tercaSW);
        quartaSW = (CheckBox) findViewById(R.id.quartaSW);
        quintaSW = (CheckBox) findViewById(R.id.quintaSW);
        sextaSW = (CheckBox) findViewById(R.id.sextaSW);
        sabadoSW = (CheckBox) findViewById(R.id.sabadoSW);
        domingoSW = (CheckBox) findViewById(R.id.domingoSW);

        confirmBTN = (Button) findViewById(R.id.confirmBTN);

        confirmBTN.setOnClickListener(confirmAction());

    }

    public View.OnClickListener confirmAction() {
        return (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
