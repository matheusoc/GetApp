package br.com.getapp.structure.controller;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashSet;

import br.com.getapp.R;
import br.com.getapp.structure.SQL.DataBase;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.MainActivity;

/**
 * Created by matheusoliveira on 10/03/2016.
 */
public class CallTimePicker extends DialogFragment {

    private  TimePicker picker;
    private TimePickerDialog tmDialog;
    private Button btnCancel;
    private Button btnOk;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return dialog(getActivity(), hour, minute, DateFormat.is24HourFormat(getActivity()));
    }

    public Dialog dialog(final Context context, int hour,  int minute,  boolean is24HourView) {
        final Dialog  d = new Dialog(context);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.timepicker_layout, null);

        picker = (TimePicker) layout.findViewById(R.id.timePicker);
        picker.setCurrentHour(hour);
        picker.setCurrentMinute(minute);
        picker.setIs24HourView(is24HourView);

        btnCancel = (Button) layout.findViewById(R.id.cancelButton);
        btnOk = (Button) layout.findViewById(R.id.okButton);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d.cancel();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alarm alarm = new Alarm(String.valueOf(picker.getCurrentHour()), String.valueOf(picker.getCurrentMinute()));
                DataBase db = new DataBase(context);
                db.insert(alarm);
                ((MainActivity) getActivity()).refreshList();
                d.cancel();
            }
        });

        d.setContentView(layout);
        return d;
    }


}
