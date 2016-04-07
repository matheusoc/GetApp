package br.com.getapp.structure.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.getapp.structure.model.Alarm;

/**
 * Created by User on 29/03/2016.
 */
public class DataBase  {

    private SQLiteDatabase db;

    public DataBase (Context context) {
        BDCore auxDB = new BDCore(context);
        db = auxDB.getWritableDatabase();
    }

    public void insert(Alarm alarm) {
        ContentValues values = new ContentValues();
        values.put("hour", alarm.getHora());
        values.put("minute", alarm.getMinuto());
        values.put("monday", alarm.getSegunda());
        values.put("tuesday", alarm.getTerca());
        values.put("wednesday", alarm.getQuarta());
        values.put("thursday", alarm.getQuinta());
        values.put("friday", alarm.getSexta());
        values.put("saturday", alarm.getSabado());
        values.put("sunday", alarm.getDomingo());

        db.insert("alarms", null, values);
    }

    public void refresh(Alarm alarm) {
        ContentValues values = new ContentValues();
        values.put("hour", alarm.getHora());
        values.put("minute", alarm.getMinuto());
        values.put("monday", alarm.getSegunda());
        values.put("tuesday", alarm.getTerca());
        values.put("wednesday", alarm.getQuarta());
        values.put("thursday", alarm.getQuinta());
        values.put("friday", alarm.getSexta());
        values.put("saturday", alarm.getSabado());
        values.put("sunday", alarm.getDomingo());

        db.update("alarms", values, "_id = ?", new String[]{"" + alarm.getID()});
    }

    public void delete(Alarm alarm) {
        db.delete("alarms", "_id = " + alarm.getID(), null);
    }

    public ArrayList<Alarm> search() {
        ArrayList<Alarm> list = new ArrayList<>();
        String[] column = new String[]{"_id","hour","minute","monday","tuesday","wednesday","thursday",
                "friday","saturday","sunday"};
        Cursor cursor = db.query("alarms", column, null, null, null, null, "hour ASC");;
        try {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    Alarm alarm = new Alarm();
                    alarm.setID(cursor.getInt(0));
                    alarm.setHora(cursor.getString(1));
                    alarm.setMinuto(cursor.getString(2));
                    alarm.setSegunda(cursor.getString(3));
                    alarm.setTerca(cursor.getString(4));
                    alarm.setQuarta(cursor.getString(5));
                    alarm.setQuinta(cursor.getString(6));
                    alarm.setSexta(cursor.getString(7));
                    alarm.setSabado(cursor.getString(8));
                    alarm.setDomingo(cursor.getString(9));

                    list.add(alarm);

                } while (cursor.moveToNext());
            }
        } finally {
            cursor.close();
        }

        return (list);
    }
}
