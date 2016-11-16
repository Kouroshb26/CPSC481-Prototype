package kourosh.drivingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFuel);
        setSupportActionBar(toolbar);

        mListView = (ListView) findViewById(R.id.fuel_list_view);

        fuelList = Fuel.getfuelsFromFile("fuelData.json", this);

        adapter = new FuelItemAdapter(this, fuelList);
        mListView.setAdapter(adapter);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
            return false;
        } else if(id == R.id.menu_service){
            Intent intent = new Intent(this,ServiceHistory.class);
            startActivity(intent);
            return false;
        }else  if (id == R.id.menu_home){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return false;
        }else if(id == R.id.menu_info){
            Intent intent= new Intent(this,info.class);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }
}
