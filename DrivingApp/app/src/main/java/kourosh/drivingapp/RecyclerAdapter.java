package kourosh.drivingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kourosh on 2016-11-11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public static final int GAUGE = 0;
    public static final int SERVICE = 1;
   List<Activity> activities;
    RecyclerAdapter(List<Activity> activities){
        this.activities = activities;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View v){
            super(v);
        }
    }


    public class GaugeViewHolder extends ViewHolder{
        ImageView gauge;
        public GaugeViewHolder (View v){
            super(v);
            this.gauge = (ImageView) v.findViewById(R.id.gauge);
        }
    }

    public class ServiceViewHolder extends ViewHolder{
        TextView title;
        TextView description;
        ImageView service;
        ServiceViewHolder(View itemView){
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            service = (ImageView)itemView.findViewById(R.id.image_type);
        }
    }



    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;

        if (viewType == GAUGE){
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gauge,parent,false);
            return new GaugeViewHolder(v);
        }else {
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service,parent,false);
            return new ServiceViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        if (viewHolder.getItemViewType()== GAUGE){
            GaugeViewHolder holder = (GaugeViewHolder) viewHolder;
            holder.gauge.setImageResource(activities.get(position).photoid);
        }else {
            ServiceViewHolder holder = (ServiceViewHolder) viewHolder;
            holder.description.setText(activities.get(position).description);
            holder.title.setText(activities.get(position).title);
            holder.service.setImageResource(activities.get(position).photoid);
        }
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public int getItemViewType(int position){
        return activities.get(position).type;
    }
}
