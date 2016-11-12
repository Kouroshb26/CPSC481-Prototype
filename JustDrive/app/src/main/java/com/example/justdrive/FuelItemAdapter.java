package com.example.justdrive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by patrickczeczko on 2016-11-12.
 */

public class FuelItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<Fuel> mDataSource;

    public FuelItemAdapter(Context context, ArrayList<Fuel> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_fuel, parent, false);

        // Get amount element
        TextView amountTextView =
                (TextView) rowView.findViewById(R.id.fuel_list_amountFueled);

        // Get date element
        TextView dateTextView =
                (TextView) rowView.findViewById(R.id.fuel_list_date);

        TextView costTextView=
                (TextView) rowView.findViewById(R.id.fuel_list_cost);

        Fuel fuel = (Fuel) getItem(position);

        amountTextView.setText(fuel.amountFueled);
        dateTextView.setText(fuel.date);
        costTextView.setText(fuel.cost);

        return rowView;
    }
}
