package kourosh.drivingapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class AddService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
    }

    //Just save all the text information for now. Doesn't actually open Camera
    public void addPhoto(View v) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivity(intent);
    }


    public void save(View view) {
        Intent intent = new Intent();

        EditText eT = (EditText) findViewById(R.id.addTitle);
        String newTitle = eT.getText().toString();

        eT = (EditText) findViewById(R.id.addDate);
        String newDate = eT.getText().toString();

        eT = (EditText) findViewById(R.id.addType);
        String newType = eT.getText().toString();

        eT = (EditText) findViewById(R.id.addCurKM);
        String newCurKM = eT.getText().toString();

        intent.putExtra("title", newTitle);
        intent.putExtra("date", newDate);
        intent.putExtra("type", newType);
        intent.putExtra("current_KM", newCurKM);

        setResult(RESULT_OK, intent);
        finish();
        this.finish();
    }
}
