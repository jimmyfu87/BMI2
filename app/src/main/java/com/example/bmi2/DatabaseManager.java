package com.example.bmi2;

/**
 * Created by IceMann on 23/2/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    private Dbhelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DatabaseManager(Context c) {
        this.context = c;
    }

    public DatabaseManager open() throws SQLException {
        dbHelper = new Dbhelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String name, String height,String weight,String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.NAME, name);
        contentValues.put(dbHelper.HEIGHT, height);
        contentValues.put(dbHelper.WEIGHT, weight);
        contentValues.put(dbHelper.DATE, date);
        database.insert(dbHelper.tb_name, null, contentValues);

    }

    public void update(String name, String height,String weight,String date) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(dbHelper.HEIGHT, height);
        contentValues.put(dbHelper.WEIGHT, weight);
        contentValues.put(dbHelper.DATE, date);
        database.update(dbHelper.tb_name, contentValues, dbHelper.NAME + "=" +"'"+name+"'", null);

    }

    public void delete(String name) {
        database.delete(dbHelper.tb_name,dbHelper.NAME + " ='" + name + "'",null);
    }

    public Cursor fetch() {
        String[] columns = new String[]{dbHelper._ID, dbHelper.NAME, dbHelper.HEIGHT,dbHelper.WEIGHT,dbHelper.DATE};
        Cursor cursor = database.query(dbHelper.tb_name, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    public Cursor fetchDATE(String starttime,String endtime) {
        return database.rawQuery
                ("select * from Bmi where dateTime(date) between datetime('"+starttime+"') and datetime('"+endtime+"')"+"ORDER BY date DESC",null);
    }
}
