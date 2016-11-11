package kourosh.drivingapp;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by kourosh on 2016-11-11.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

   List<Activity> activities;
    RecyclerAdapter(List<Activity> activities){
        this.activities = activities;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView title;
        TextView description;
        ImageView service;
        ViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.card_view);
            title = (TextView)itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            service = (ImageView)itemView.findViewById(R.id.image_type);
        }
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_main,parent,false);
        ViewHolder rvh = new ViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(activities.get(position).title);
        holder.description.setText(activities.get(position).description);
        holder.service.setImageResource(activities.get(position).photoid);
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }
}
