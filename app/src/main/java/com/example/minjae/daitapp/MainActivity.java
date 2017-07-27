package com.example.minjae.daitapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button fast1;
    Button fast2;
    Button alarms;
    Switch onOff;

    String date = "20170727";
    String time = "1530";

    String text1 = "20170727 / 1530";
    String text2 = "";
    boolean ischecked = false;

    SharedPreferences switchPre;
    SharedPreferences.Editor editor1;
    SharedPreferences fast1Pre;
    SharedPreferences.Editor editor2;
    SharedPreferences fast2Pre;
    SharedPreferences.Editor editor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fast1 = (Button) findViewById(R.id.fast1);
        fast2 = (Button) findViewById(R.id.fast2);
        alarms = (Button) findViewById(R.id.alarms);
        onOff = (Switch) findViewById(R.id.onOff);

        switchPre = getSharedPreferences("onOff", MODE_PRIVATE);
        fast1Pre = getSharedPreferences("fast1", MODE_PRIVATE);
        fast2Pre = getSharedPreferences("fast2", MODE_PRIVATE);

        fast1.setText(text1);
        text2 = fast2Pre.getString("fast2", "");
        fast2.setText(text2);

        ischecked = switchPre.getBoolean("onOff", false);
        if(ischecked) onOff.toggle();


        alarms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Alarms.class);
                startActivity(intent);
            }
        });

        fast1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "해당 시간에 알람이 설정되었습니다.", Toast.LENGTH_LONG).show();
            }
        });
        fast2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "해당 시간에 알람이 설정되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.save :
                editor3 = fast2Pre.edit();
                editor3.putString("fast2", text2);
                editor3.commit();
                if (onOff.isChecked()){
                    editor1 = switchPre.edit();
                    editor1.putBoolean("onOff", true);
                    editor1.commit();
                }
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                date = data.getExtras().getString("fast_date");
                time = data.getExtras().getString("fast_time");
                text2 = date + " / " + time;
                fast2.setText(text2);
            }
            else {
                Toast.makeText(getApplicationContext(), "Failed to load data.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
