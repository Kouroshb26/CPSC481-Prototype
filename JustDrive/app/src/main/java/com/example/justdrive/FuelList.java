package com.example.justdrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FuelList extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_list);

        mListView = (ListView) findViewById(R.id.fuel_list_view);

        final ArrayList<Fuel> fuelList = Fuel.getfuelsFromFile("fuelData.json", this);

        FuelItemAdapter adapter = new FuelItemAdapter(this, fuelList);
        mListView.setAdapter(adapter);
    }
}
