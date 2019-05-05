package com.example.bmi2;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class result_activity extends AppCompatActivity {
    private EditText et1,et2,et3,et4,et5;
    private Button b1,b2,b3,b4;
    private DatabaseManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private Dbhelper dbHelper;
    private String startdate,enddate;

    final String[] from = new String[]{dbHelper._ID, dbHelper.NAME, dbHelper.HEIGHT,dbHelper.WEIGHT,dbHelper.DATE};
    final int[] to = new int[]{R.id.id, R.id.name, R.id.height,R.id.weight,R.id.date};



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Intent getSaveData = getIntent();
        Bundle getSaveBag = getSaveData.getExtras();
        if(getSaveBag != null){
            startdate=getSaveBag.getString("start");
            enddate=getSaveBag.getString("end");
        }

        DatabaseManager dbManager2 = new DatabaseManager(getApplicationContext());
        dbManager2.open();
        Cursor cursor = dbManager2.fetchDATE(startdate,enddate);

        listView = (ListView) findViewById(R.id.myListView);
        adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.adapter, cursor, from, to, 0);
        listView.setAdapter(adapter);

    }
    }