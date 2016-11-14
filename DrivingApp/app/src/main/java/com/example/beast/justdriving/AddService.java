package com.example.beast.justdriving;

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

    EditText title, date, cKM;
    AutoCompleteTextView type;
    String DB = "data.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        title = (EditText)findViewById(R.id.addTitle);
    }

    //Just save all the text information for now. Doesn't actually open Camera
//    public void selectImage() {
//        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
//        startActivity(intent);
//    }


    public void save(View v) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(openFileOutput(DB, 0));
            out.write(title.getText().toString());
            out.close();
            Toast.makeText(this, "Information has been saved", Toast.LENGTH_LONG).show();
        }
        catch(Throwable t) {
            Toast.makeText(this, "Exception: "+t.toString(), Toast.LENGTH_LONG).show();
        }
        test();
    }

    public void test() {
        File file = new File ("data.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
