package kourosh.drivingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import kourosh.drivingapp.R;

public class FuelList extends AppCompatActivity {
    private ListView mListView;
    ArrayList<Fuel> fuelList;
    FuelItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel_list);

        mListView = (ListView) findViewById(R.id.fuel_list_view);

        fuelList = Fuel.getfuelsFromFile("fuelData.json", this);

        adapter = new FuelItemAdapter(this, fuelList);
        mListView.setAdapter(adapter);
    }

    /** Called when the user clicks the add button */
    public void addFuelItem(View view) {
        Intent intent = new Intent(this, AddFuelActivity.class);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("amount_fueled_up");
                Log.d("myTag", stredittext);

                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

                Fuel newItem = new Fuel("random",date,
                        data.getStringExtra("amount_fueled_up") + " L",
                        data.getStringExtra("current_milage"),
                        "$"+data.getStringExtra("amount_paid"));
                fuelList.add(0,newItem);
                adapter.notifyDataSetChanged();
            }
        }
    }
}
