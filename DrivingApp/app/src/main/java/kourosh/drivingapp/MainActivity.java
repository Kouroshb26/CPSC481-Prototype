package kourosh.drivingapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
        }

        return super.onOptionsItemSelected(item);
    }
}
