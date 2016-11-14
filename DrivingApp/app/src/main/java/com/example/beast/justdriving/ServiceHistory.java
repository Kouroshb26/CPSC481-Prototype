package com.example.beast.justdriving;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_history);
    }

    public void addService(View view) {
        Intent intent = new Intent(this, AddService.class);
        startActivity(intent);
    }

    public void check(View view) {
        Intent intent = new Intent(this, ServiceView.class);
        startActivity(intent);
    }
}
