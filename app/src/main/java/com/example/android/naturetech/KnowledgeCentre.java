package com.example.android.naturetech;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeCentre extends Activity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_centre);

        Spinner vegetableDropdown = (Spinner) findViewById(R.id.spinner); // vegetables
        Spinner seasonDropdown = (Spinner) findViewById(R.id.spinner2); // time period
        Spinner locationDropdown = (Spinner) findViewById(R.id.spinner3); // location

        vegetableDropdown.setOnItemSelectedListener(this);
        seasonDropdown.setOnItemSelectedListener(this);
        locationDropdown.setOnItemSelectedListener(this);


    /* Dropdown creation for vegetables */

        List<String> vegetables = new ArrayList<>();
        vegetables.add("Tomato");
        vegetables.add("Potato");
        vegetables.add("Cauliflower");
        vegetables.add("Brinjal");
        vegetables.add("Cucumber");
        vegetables.add("Paprika");
        vegetables.add("Bottle Gourd");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vegetables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        vegetableDropdown.setAdapter(dataAdapter);
        vegetableDropdown.setPrompt("Select the vegetable you want to plant");


        /* Dropdown creation for season */

        List<String> season = new ArrayList<>();
        season.add("Summer");
        season.add("Winter");
        season.add("Spring");
        season.add("Autumn");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, season);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        seasonDropdown.setAdapter(dataAdapter2);
        seasonDropdown.setPrompt("Select the season you will plant in");


        /* Dropdown creation for location */

        List<String> location = new ArrayList<>();
        location.add("Haryana");
        location.add("New Delhi");
        location.add("Madhya Pradesh");
        location.add("Punjab");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, location);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        locationDropdown.setAdapter(dataAdapter3);
        locationDropdown.setPrompt("Select your state");

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}