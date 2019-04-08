//package com.example.bmi2;
//
//import android.app.ListActivity;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.widget.ListView;
//import android.widget.SimpleCursorAdapter;
//
//public class QueryActivity extends ListActivity {
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setTitle("BMI紀錄");
//        final Dbhelper helpter = new Dbhelper(this);
//        Cursor c = helpter.query();
//        String[] from = {"name", "height", "weight"};
//        int[] to = {R.id.text0, R.id.text1, R.id.text2};
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, c, from, to);
//        ListView listView = getListView();
//        listView.setAdapter(adapter);
//    }
//}
