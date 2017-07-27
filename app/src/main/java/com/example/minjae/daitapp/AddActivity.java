package com.example.minjae.daitapp;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TimePickerDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.CheckResult;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RequiresApi(api = Build.VERSION_CODES.N)
public class AddActivity extends AppCompatActivity {

    private TextView setDate;
    private TextView setTime;
    private CheckBox checkBox;

    public long mNow;
    public Date mDate;
    public SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
    public String date = "";
    public String time = "";

    private Button add;

    public DatePickerDialog datePickerDialog;
    public TimePickerDialog timePickerDialog;

    public Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        
        intent = new Intent();
        intent.putExtra("year", 2017);
        intent.putExtra("month", 7);
        intent.putExtra("day", 27);
        intent.putExtra("hour", 1);
        intent.putExtra("minute", 30);
        intent.putExtra("fast_date", "20170727");
        intent.putExtra("fast_time", "1540");

        setDate = (TextView) findViewById(R.id.setDate);
        setTime = (TextView) findViewById(R.id.setTime);
        checkBox = (CheckBox) findViewById(R.id.check_fast);
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        date = dateFormat.format(mDate);
        time = timeFormat.format(mDate);
        setDate.setText(date);
        setTime.setText(time);
        add = (Button) findViewById(R.id.btn_add);

        datePickerDialog = new DatePickerDialog(this, dateListener, 2017, 7, 25);
        timePickerDialog = new TimePickerDialog(this, timeListener, 12, 00, true);

        setDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
        setTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog.show();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    intent.putExtra("fast_date", date);
                    intent.putExtra("fast_time", time);
                }
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            date = year + "-" + month + "-" + day;
            setDate.setText(date);
            intent.putExtra("year", year);
            intent.putExtra("month", month);
            intent.putExtra("day", day);
        }
    };

    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            time = hour + ":" + minute;
            setTime.setText(time);
            intent.putExtra("hour", hour);
            intent.putExtra("minute", minute);
        }
    };

}
