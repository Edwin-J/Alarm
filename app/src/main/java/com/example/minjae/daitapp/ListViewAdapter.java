package com.example.minjae.daitapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Minjae on 2017-07-25.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewItem> arrayList = new ArrayList<ListViewItem>();

    public ListViewAdapter() {  }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        TextView date = (TextView) convertView.findViewById(R.id.setDate);
        TextView time = (TextView) convertView.findViewById(R.id.setTime);

        ListViewItem listViewItem = arrayList.get(pos);

        date.setText(listViewItem.getDate());
        time.setText(listViewItem.getTime());

        return convertView;
    }

    public void addItem(String title, String date, String time, Switch onOff){
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setDate(date);
        item.setTime(time);

        arrayList.add(item);
    }
}
