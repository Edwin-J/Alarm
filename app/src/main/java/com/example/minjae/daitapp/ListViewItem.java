package com.example.minjae.daitapp;

import android.widget.Switch;

/**
 * Created by Minjae on 2017-07-25.
 */

public class ListViewItem {
    private String title;
    private Switch onOff;
    private String date;
    private String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Switch getOnOff() {
        return onOff;
    }

    public void setOnOff(Switch onOff) {
        this.onOff = onOff;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
