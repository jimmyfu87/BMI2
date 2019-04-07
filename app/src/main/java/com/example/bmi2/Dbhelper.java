package com.example.bmi2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Dbhelper extends SQLiteOpenHelper {

    private static final String db_name="bmi.db";
    private static final String tb_name="Bmi";
    private  static final String create_tb=
            "CREATE TABLE IF NOT EXISTS " + "Bmi" + " ("
            + "_id" + " INTEGER primary key autoincrement, "
            + "name" + " text , "
            + "height" + " text , "
            + "weight" + " text "+ ");";
    private SQLiteDatabase db;
    Dbhelper(Context c) {
        super(c, db_name, null, 2);
    }

    @Override

    public void onCreate(SQLiteDatabase db) {
            this.db=db;
            db.execSQL(create_tb);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {


    }
    public void insert(ContentValues values){
        SQLiteDatabase db=getWritableDatabase();
        db.insert(tb_name,null,values);
        db.close();
    }
    public Cursor query(){
        SQLiteDatabase db=getWritableDatabase();
        Cursor c=db.query(tb_name,null,null,null,null,null,null);
        return c;
    }
    public void del(int id){
        if (db==null){
            db=getWritableDatabase();
        }
        db.delete(tb_name,"_id=?",new String[]{String.valueOf(id)});
    }

    public void close(){
        if(db!=null){
            db.close();
        }
    }
}
