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

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    private Button b1,b2;
    private DatabaseManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private Dbhelper dbHelper;
    private Context c;

    final String[] from = new String[]{dbHelper._ID, dbHelper.NAME, dbHelper.HEIGHT,dbHelper.WEIGHT};
    final int[] to = new int[]{R.id.id, R.id.name, R.id.height,R.id.weight};



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.height);
        et3=(EditText)findViewById(R.id.weight);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        final Dbhelper helpter = new Dbhelper(this);
        
//        dbManager.open();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=et1.getText().toString();
                String height=et2.getText().toString();
                String weight=et3.getText().toString();
//                ContentValues values=new ContentValues();
//                values.put("name",name);
//                values.put("height",height);
//                values.put("weight",weight);
                DatabaseManager dbmanager2=new DatabaseManager(getApplicationContext());
                dbmanager2.open();
                dbmanager2.insert(name,height,weight);
                dbmanager2.close();
//                Intent intent=new Intent(MainActivity.this,QueryActivity.class);
//                startActivity(intent);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Cursor c = helpter.query();
//                String[] from = {"name", "height", "weight"};
//                int[] to = {R.id.text0, R.id.text1, R.id.text2};
//                SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, from, to);
//                DatabaseManager dbManager = new DatabaseManager();
//                dbManager.open();
//                Cursor cursor = dbManager.fetch();
//
//                listView = (ListView) findViewById(R.id.myListView);
//                adapter = new SimpleCursorAdapter(c, R.layout.adapter, cursor, from, to, 0);
//                listView.setAdapter(adapter);
                DatabaseManager dbManager = new DatabaseManager(getApplicationContext());
                dbManager.open();
                Cursor cursor = dbManager.fetch();

                listView = (ListView) findViewById(R.id.myListView);
                adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.adapter, cursor, from, to, 0);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
