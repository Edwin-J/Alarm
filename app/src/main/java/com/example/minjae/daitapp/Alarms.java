package com.example.minjae.daitapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Alarms extends AppCompatActivity {

    ImageButton btn_add;
    ListView list;
    ListViewAdapter adapter;

    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarms);

        btn_add = (ImageButton) findViewById(R.id.btn_add);
        list = (ListView) findViewById(R.id.alarmList);
        adapter = new ListViewAdapter();
        list.setAdapter(adapter);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                AlertDialog.Builder builder = new AlertDialog.Builder(Alarms.this);
                builder.setTitle("알람 삭제");
                builder.setMessage("알람을 삭제하시겠습니까 ?").setCancelable(false);
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.delItem(pos);
                        adapter.notifyDataSetChanged();
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String alarms[] = {"alarm1", "alarm2", "alarm3", "alarm4", "alarm5"};

                year = data.getExtras().getInt("year");
                month = data.getExtras().getInt("month");
                day = data.getExtras().getInt("day");
                hour = data.getExtras().getInt("hour");
                minute = data.getExtras().getInt("minute");
                adapter.addItem(year, month, day, hour, minute);
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), "Success.", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Failed to load data.", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
