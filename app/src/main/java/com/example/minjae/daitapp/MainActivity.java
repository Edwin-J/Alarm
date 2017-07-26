package com.example.minjae.daitapp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    Button fast1;
    Button fast2;
    Button alarms;
    Switch onOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fast1 = (Button) findViewById(R.id.fast1);
        fast2 = (Button) findViewById(R.id.fast2);
        alarms = (Button) findViewById(R.id.alarms);
        onOff = (Switch) findViewById(R.id.onOff);

        Intent intent = new Intent(getApplicationContext(), Alarms.class);
        startActivity(intent);

    }
}
