package br.com.getapp.structure.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 29/03/2016.
 */
public class BDCore extends SQLiteOpenHelper {

    private static final String NOME_DB = "alarm";
    private static final int DB_VERSION = 1;

    public BDCore(Context context) {
        super(context, NOME_DB, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table alarms(_id integer primary key autoincrement, hour integer not null, " +
                "minute integer not null, monday text not null, tuesday text not null, wednesday text not null," +
                "thursday text not null, friday text not null, saturday text not null, sunday text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table alarm;");
        onCreate(db);
    }
}
