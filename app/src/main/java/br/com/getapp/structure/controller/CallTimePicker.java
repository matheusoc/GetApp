package br.com.getapp.structure.controller;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashSet;

import br.com.getapp.structure.SQL.DataBase;
import br.com.getapp.structure.model.Alarm;
import br.com.getapp.structure.view.MainActivity;

/**
 * Created by matheusoliveira on 10/03/2016.
 */
public class CallTimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Alarm alarm = new Alarm(String.valueOf(hourOfDay), String.valueOf(minute));
        DataBase db = new DataBase(getActivity());
        db.insert(alarm);

        ((MainActivity) getActivity()).refreshList();

    }

}
