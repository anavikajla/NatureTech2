package com.example.android.naturetech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeCentre extends Activity implements AdapterView.OnItemSelectedListener {

    public static String vegSelection, seedTypeSelection;

    Spinner vegetableDropdown;
    Spinner seasonDropdown;
    Button search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge_centre);

        vegetableDropdown = (Spinner) findViewById(R.id.spinner); // vegetables
        seasonDropdown = (Spinner) findViewById(R.id.spinner2); // time period
        // Spinner locationDropdown = (Spinner) findViewById(R.id.spinner3); // location

        search = (Button) findViewById(R.id.search);

        vegetableDropdown.setOnItemSelectedListener(this);
        seasonDropdown.setOnItemSelectedListener(this);
        //locationDropdown.setOnItemSelectedListener(this);

        // if(vegetableDropdown.equals("Tomato"))


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(KnowledgeCentre.this, VegetableTemplate.class);
                startActivity(i);
            }
        });



    /* Dropdown creation for vegetables */
        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> vegetables = databaseAccess.getVegetables();
        databaseAccess.close();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vegetables);

        // attaching data adapter to spinner
        vegetableDropdown.setAdapter(dataAdapter);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        vegetableDropdown.setPrompt("Select the vegetable you want to plant");



        /* Dropdown creation for seed type  */
        List<String> seedType = new ArrayList<>();
        seedType.add("Normal");
        seedType.add("Hybrid");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, seedType);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        seasonDropdown.setAdapter(dataAdapter2);
        seasonDropdown.setPrompt("Select the seedType");



        /* Dropdown creation for location */
        /*List<String> location = new ArrayList<>();
        location.add("Andaman and Nicobar Islands");
        location.add("Andhra Pradesh");
        location.add("Arunachal Pradesh");
        location.add("Assam");
        location.add("Bihar (BR)");
        location.add("Chandigarh");
        location.add("Chhattisgarh");
        location.add("Dadra and Nagar Haveli");
        location.add("Daman and Diu");
        location.add("Goa");
        location.add("Gujarat");
        location.add("Haryana");
        location.add("Himachal Pradesh");
        location.add("Jammu and Kashmir");
        location.add("Jharkhand");
        location.add("Karnataka");
        location.add("Kerala");
        location.add("Lakshadweep");
        location.add("Madhya Pradesh");
        location.add("Maharashtra");
        location.add("Manipur");
        location.add("Meghalaya");
        location.add("Mizoram");
        location.add("Nagaland");
        location.add("National Capital Territory of Delhi");
        location.add("Odisha");
        location.add("Pondicherry");
        location.add("Punjab");
        location.add("Rajasthan");
        location.add("Sikkim");
        location.add("Tamil Nadu");
        location.add("Tripura");
        location.add("Uttar Pradesh");
        location.add("Uttarakhand");
        location.add("West Bengal");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, location);

        // attaching data adapter to spinner
        locationDropdown.setAdapter(dataAdapter3);

        // Drop down layout style - list view with radio button
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        locationDropdown.setPrompt("Select your state");*/
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        vegSelection = vegetableDropdown.getSelectedItem().toString();
        seedTypeSelection = seasonDropdown.getSelectedItem().toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}

