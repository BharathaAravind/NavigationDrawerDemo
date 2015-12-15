package com.example.aravind.navigationdrawerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodAppHomeScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button submit_btn;
    private Spinner loc_spinner,subLoc_spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_app_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        submit_btn = (Button)findViewById(R.id.submit);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        loc_spinner = (Spinner)findViewById(R.id.location_spinner);
        subLoc_spinner = (Spinner)findViewById(R.id.sublocation_spinner);

        loc_spinner.setOnItemSelectedListener(this);
        subLoc_spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> locations = new ArrayList<String>();
        locations.add("Hyderabad");
        locations.add("Banglore");
        locations.add("Pune");
        locations.add("Mysore");
        locations.add("Chandigarh");
        locations.add("Chennai");
        locations.add("Jaipur");
        locations.add("Trivandrum");
        locations.add("Bhubaneswar");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, locations);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        loc_spinner.setAdapter(dataAdapter);

        List<String> subLocations = new ArrayList<String>();
        subLocations.add("SEZ");
        subLocations.add("STP");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, subLocations);

        // Drop down layout style - list view with radio button
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        subLoc_spinner.setAdapter(dataAdapter1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(parent.getContext(),"clicked!",Toast.LENGTH_LONG);
        Log.d("see","clicked!");
        if(parent.getId()==R.id.location_spinner){
            subLoc_spinner.setVisibility(View.VISIBLE);
            Toast.makeText(parent.getContext(), "clicked!", Toast.LENGTH_LONG);
            Log.d("see", "clicked!!");

        }
        if(parent.getId()==R.id.sublocation_spinner){
            submit_btn.setEnabled(true);
            submit_btn.setVisibility(View.VISIBLE);
            Log.d("see", "clicked!!");

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
