package com.example.huy.assignment_inf205.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.huy.assignment_inf205.Model.book;
import com.example.huy.assignment_inf205.R;

import java.util.ArrayList;

/**
 * Created by Huy on 04/16/2017.
 */
public class listBookAdapter extends ArrayAdapter {
    Activity context;
    int layoutId;
    ArrayList<book> listBook;
    public listBookAdapter(Activity context, int resource, ArrayList<book> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layoutId = resource;
        this.listBook = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            convertView = inflater.inflate(layoutId, null);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvListName);
        TextView tvTacgia = (TextView) convertView.findViewById(R.id.tvListTacgia);
        TextView tvSL = (TextView) convertView.findViewById(R.id.tvListSL);
        TextView tvTT = (TextView) convertView.findViewById(R.id.tvListStatus);

        book target = listBook.get(position);
        tvName.setText(target.getNamebook());
        tvTacgia.setText(target.getTacgia());
        tvSL.setText(String.valueOf(target.getSl()));
        if(target.isStatus()){
            tvTT.setText("Đang bán!");
        }else {
            tvTT.setText("Ngưng bán!");
        }
        return convertView;
    }
}
