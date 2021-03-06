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
    private EditText et1,et2,et3,et4,et5;
    private Button b1,b2,b3,b4;
    private DatabaseManager dbManager;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    private Dbhelper dbHelper;

    final String[] from = new String[]{dbHelper._ID, dbHelper.NAME, dbHelper.HEIGHT,dbHelper.WEIGHT,dbHelper.DATE};
    final int[] to = new int[]{R.id.id, R.id.name, R.id.height,R.id.weight,R.id.date};



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.height);
        et3=(EditText)findViewById(R.id.weight);
        et4=(EditText)findViewById(R.id.date);
        et5=(EditText)findViewById(R.id.enddate);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        final Dbhelper helpter = new Dbhelper(this);

//        dbManager.open();



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=et1.getText().toString();
                String height=et2.getText().toString();
                String weight=et3.getText().toString();
                String date=et4.getText().toString();
//                ContentValues values=new ContentValues();
//                values.put("name",name);
//                values.put("height",height);
//                values.put("weight",weight);
                DatabaseManager dbmanager1=new DatabaseManager(getApplicationContext());
                dbmanager1.open();
                dbmanager1.insert(name,height,weight,date);
                dbmanager1.close();
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
                Intent intent = new Intent(MainActivity.this,result_activity.class);
                Bundle saveExpenseData = new Bundle();
                String startdate=et4.getText().toString();
                String enddate=et5.getText().toString();
                saveExpenseData.putString("start",startdate);
                saveExpenseData.putString("end",enddate);
                intent.putExtras(saveExpenseData);
                startActivity(intent);



//                DatabaseManager dbManager2 = new DatabaseManager(getApplicationContext());
//                dbManager2.open();
//                Cursor cursor = dbManager2.fetchDATE(startdate,enddate);
//
//                listView = (ListView) findViewById(R.id.myListView);
//                adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.adapter, cursor, from, to, 0);
//                listView.setAdapter(adapter);
//                //adapter.notifyDataSetChanged();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String newheight=et2.getText().toString();
                String newweight=et3.getText().toString();
                String newdate=et4.getText().toString();
                DatabaseManager dbmanager=new DatabaseManager(getApplicationContext());
                dbmanager.open();
                dbmanager.update(name,newheight,newweight,newdate);
                dbmanager.close();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                DatabaseManager dbmanager=new DatabaseManager(getApplicationContext());
                dbmanager.open();
                dbmanager.delete(name);
                dbmanager.close();

            }
        });
    }
}
