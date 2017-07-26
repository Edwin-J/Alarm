package com.example.minjae.daitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class Alarms extends AppCompatActivity {

    ArrayList<ListViewItem> arrayList = new ArrayList<>();
    ImageButton btn_add;
    ListView list;
    ListViewAdapter adapter;

    public String date;
    public String time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);

        btn_add = (ImageButton) findViewById(R.id.btn_add);
        list = (ListView) findViewById(R.id.alarmList);
        adapter = new ListViewAdapter(arrayList, this);
        list.setAdapter(adapter);

        Intent intent = getIntent();
        date = intent.getExtras().getString("date");
        time = intent.getExtras().getString("time");
        adapter.addItem(date, time);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent1, 0);
            }
        });
    }
}
