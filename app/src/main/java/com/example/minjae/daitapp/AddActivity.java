package com.example.minjae.daitapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.CheckResult;
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

import java.util.Date;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

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
                Intent intent = new Intent();
                intent.putExtra("date", ""+date);
                intent.putExtra("time", ""+time);
                setResult(RESULT_OK, intent);
            }
        });
    }

    private DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int day) {
            date = year + "-" + month + "-" + day;
            setDate.setText(date);
        }
    };
    private TimePickerDialog.OnTimeSetListener timeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            time = hour + ":" + minute;
            setTime.setText(time);
        }
    };

}
