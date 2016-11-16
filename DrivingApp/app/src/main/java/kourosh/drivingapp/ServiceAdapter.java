package kourosh.drivingapp;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceAdapter extends BaseAdapter {
    Context cont;
    LayoutInflater lI;
    ArrayList<Service> serv;

    public ServiceAdapter(Context context, ArrayList<Service> items) {
        cont = context;
        lI = (LayoutInflater) cont.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        serv = items;
    }

    @Override
    public int getCount() {
        return serv.size();
    }

    @Override
    public Object getItem(int position) {
        return serv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rView = lI.inflate(R.layout.list_item_service, parent, false);

        TextView titleTV = (TextView) rView.findViewById(R.id.title);
        TextView dateTV = (TextView) rView.findViewById(R.id.date);

        Service service = (Service) getItem(position);
        titleTV.setText(service.title);
        dateTV.setText(service.date);

        return rView;
    }
}
