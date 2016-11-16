package kourosh.drivingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ServiceView extends AppCompatActivity {
    int position = 0;
    ServiceAdapter adapter;
    ArrayList<Service> servList;
    Service service;
    TextView setTitle;
    TextView setDate;
    TextView setType;
    TextView setCurrentKM;
    String sTitle;
    String sDate;
    String sType;
    String sCurrentKM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_view);

        //Currently gets the list of premade services and shows the clicked position
        //Doesn't work if you insert something at the moment.
        Intent intent = getIntent();
        int position = intent.getIntExtra("pos", 0);
//        Bundle args = intent.getBundleExtra("bundle");
//        servList = (ArrayList<Service>) args.getSerializable("list");
        servList = Service.getServices("services.json", this);
        adapter = new ServiceAdapter(this, servList);
        service = (Service) adapter.getItem(position);

        setTitle = (TextView)findViewById(R.id.showTitle);
        setDate = (TextView)findViewById(R.id.showDate);
        setType = (TextView)findViewById(R.id.showType);
        setCurrentKM = (TextView)findViewById(R.id.showCurrKM);

        setTitle.setText(service.title);
        setDate.setText(service.date);
        setType.setText(service.type);
        setCurrentKM.setText(service.currentKM);
    }
}
