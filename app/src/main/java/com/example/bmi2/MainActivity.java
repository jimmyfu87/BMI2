package com.example.bmi2;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText et1,et2,et3;
    private Button b1;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.name);
        et2=(EditText)findViewById(R.id.height);
        et3=(EditText)findViewById(R.id.weight);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=et1.getText().toString();
                String height=et2.getText().toString();
                String weight=et3.getText().toString();
                ContentValues values=new ContentValues();
                values.put("name",name);
                values.put("height",height);
                values.put("weight",weight);
                Dbhelper helper=new Dbhelper(getApplicationContext());
                helper.insert(values);
                helper.close();
                //             Intent intent=new(AddActivity.this,QueryActivity.class);
                //            startActivity(intent);
            }
        });
    }
}
