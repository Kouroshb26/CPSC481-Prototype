package kourosh.drivingapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ServiceHistory extends AppCompatActivity {
    ListView lv;
    ArrayList<Service> services;
    ServiceAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_service);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lv = (ListView) findViewById(R.id.service_list);

        services = Service.getServices("services.json", this);

        adapter = new ServiceAdapter(this, services);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ServiceHistory.this, ServiceView.class);
                intent.putExtra("pos", position);
//                Bundle args = new Bundle();
//                args.putSerializable("list", (Serializable)services);
//                intent.putExtra("bundle", args);
                startActivity(intent);
            }
        });

    }

    //If you want to add a service
    public void addService(View view) {
        Intent intent = new Intent(this, AddService.class);
        startActivityForResult(intent, 1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String title = data.getStringExtra("title");
                String date = data.getStringExtra("date");
                //String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                String type = data.getStringExtra("type");
                String currKM = data.getStringExtra("current_KM");

                Service newService = new Service(title, date, type, currKM);
                services.add(0, newService);
                adapter.notifyDataSetChanged();
            }
        }
    }

//    public void onItemClick(View v, int position) {
//        ServiceView newServView = new ServiceView();
//        newServView.createServiceView(v, position);
//
//    }

    //If you want to open an existing service
    public void checkService(View view) {
        Intent intent = new Intent(this, ServiceView.class);
        startActivity(intent);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return false;
        } else if(id == R.id.menu_fuel){
            Intent intent = new Intent(this,FuelList.class);
            startActivity(intent);
            return false;
        } else if(id == R.id.menu_home){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return false;
        } else if(id == R.id.menu_info){
            Intent intent= new Intent(this,info.class);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}


