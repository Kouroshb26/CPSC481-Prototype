package kourosh.drivingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import kourosh.drivingapp.R;

public class AddFuelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fuel);
    }

    /** Called when the user clicks the save button */
    public void saveFuelItem(View view) {
        Intent intent = new Intent();

        EditText editText = (EditText) findViewById(R.id.edit_amount_fueled);
        String amountFueled = editText.getText().toString();

        editText = (EditText) findViewById(R.id.edit_current_milage);
        String currentMilage = editText.getText().toString();

        editText = (EditText) findViewById(R.id.edit_fuel_type);
        String fuelType = editText.getText().toString();

        editText = (EditText) findViewById(R.id.edit_amount_paid);
        String amountPaid = editText.getText().toString();

        intent.putExtra("amount_fueled_up",amountFueled);
        intent.putExtra("current_milage",currentMilage);
        intent.putExtra("fuel_type",fuelType);
        intent.putExtra("amount_paid",amountPaid);

        setResult(RESULT_OK, intent);
        finish();

        this.finish();
    }
}
