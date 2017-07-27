package com.example.minjae.daitapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Minjae on 2017-07-25.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> arrayList = new ArrayList<ListViewItem>();

    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_alarms, parent, false);
        }

        TextView yearView = (TextView) convertView.findViewById(R.id.list_year);
        TextView monthView = (TextView) convertView.findViewById(R.id.list_month);
        TextView dayView = (TextView) convertView.findViewById(R.id.list_day);
        TextView hourView = (TextView) convertView.findViewById(R.id.list_hour);
        TextView minuteView = (TextView) convertView.findViewById(R.id.list_minute);

        ListViewItem listViewItem = arrayList.get(position);

        yearView.setText(listViewItem.getYear()+"년 ");
        monthView.setText(listViewItem.getMonth()+"월 ");
        dayView.setText(listViewItem.getDay()+"일 ");
        hourView.setText(listViewItem.getHour()+"시 ");
        minuteView.setText(listViewItem.getMinute()+"분 ");

        return convertView;
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    void addItem(int year, int month, int day, int hour, int minute){
        ListViewItem item = new ListViewItem();

        item.setYear(year);
        item.setMonth(month);
        item.setDay(day);
        item.setHour(hour);
        item.setMinute(minute);

        arrayList.add(item);
    }

    void delItem(int position){
        arrayList.remove(position);
    }
}
