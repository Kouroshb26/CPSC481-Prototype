package kourosh.drivingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    private List<Activity> activities;

    private void initializeDate(){
        activities = new ArrayList<>();
        activities.add(new Activity(0,"","",R.drawable.gauge));
        activities.add(new Activity(1,"Service","Oil change is due in 5000km",R.drawable.service));
        activities.add(new Activity(1,"Fuel","300km left in tank",R.drawable.fuel));
        activities.add(new Activity(1,"Service","Oil change was done on Nov 11th",R.drawable.service));
        activities.add(new Activity(1,"Fuel","Tank was full on Nov10th",R.drawable.fuel));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.home_recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        initializeDate();
        adapter = new RecyclerAdapter(activities);
        recyclerView.setAdapter(adapter);


        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add_button);
                add.setVisibility(View.INVISIBLE);
                FloatingActionButton fuel = (FloatingActionButton) findViewById(R.id.add_fuel);
                fuel.setVisibility(View.VISIBLE);
                FloatingActionButton service = (FloatingActionButton) findViewById(R.id.add_service);
                service.setVisibility(View.VISIBLE);
                FloatingActionButton cancel = (FloatingActionButton) findViewById(R.id.cancel_button);
                cancel.setVisibility(View.VISIBLE);
            }
        });
    }

    public void add_fuel(View view){
        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add_button);
        add.setVisibility(View.VISIBLE);
        FloatingActionButton fuel = (FloatingActionButton) findViewById(R.id.add_fuel);
        fuel.setVisibility(View.INVISIBLE);
        FloatingActionButton service = (FloatingActionButton) findViewById(R.id.add_service);
        service.setVisibility(View.INVISIBLE);
        FloatingActionButton cancel = (FloatingActionButton) findViewById(R.id.cancel_button);
        cancel.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(this,AddFuelActivity.class);
        startActivity(intent);
    }

    public void add_service(View view){
        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add_button);
        add.setVisibility(View.VISIBLE);
        FloatingActionButton fuel = (FloatingActionButton) findViewById(R.id.add_fuel);
        fuel.setVisibility(View.INVISIBLE);
        FloatingActionButton service = (FloatingActionButton) findViewById(R.id.add_service);
        service.setVisibility(View.INVISIBLE);
        FloatingActionButton cancel = (FloatingActionButton) findViewById(R.id.cancel_button);
        cancel.setVisibility(View.INVISIBLE);

        Intent intent = new Intent(this, AddService.class);
        startActivity(intent);
    }

    public void cancel_action(View view){
        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.add_button);
        add.setVisibility(View.VISIBLE);
        FloatingActionButton fuel = (FloatingActionButton) findViewById(R.id.add_fuel);
        fuel.setVisibility(View.INVISIBLE);
        FloatingActionButton service = (FloatingActionButton) findViewById(R.id.add_service);
        service.setVisibility(View.INVISIBLE);
        FloatingActionButton cancel = (FloatingActionButton) findViewById(R.id.cancel_button);
        cancel.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
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
        } else if(id == R.id.menu_service){
            return false;
        } else if(id == R.id.menu_info){
            Intent intent= new Intent(this,info.class);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
