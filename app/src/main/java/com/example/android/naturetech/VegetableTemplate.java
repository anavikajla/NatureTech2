package com.example.android.naturetech;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class VegetableTemplate extends Activity {

    ListView list, list2, list3, list4, list5, list6, list7, list8;
    DatabaseAccess databaseAccess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_template);

        //Retrieving 'Seed Rate' from database
        list = (ListView) findViewById(R.id.seed_rate);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> seedRate = databaseAccess.getVegetableSeedRate();
        databaseAccess.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seedRate);
        this.list.setAdapter(adapter);

        //Retrieving 'Transplanting' from database
        list2 = (ListView) findViewById(R.id.transplanting);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> seedTransplanting = databaseAccess.getVegetableTransplanting();
        databaseAccess.close();
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, seedTransplanting);
        this.list2.setAdapter(adapter2);

        //Retrieving 'Spacing' from database
        list3 = (ListView) findViewById(R.id.spacing);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> spacing = databaseAccess.getSeedSpacing();
        databaseAccess.close();
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, spacing);
        this.list3.setAdapter(adapter3);

        //Retrieving 'Month Of Sowing' from database
        list4 = (ListView) findViewById(R.id.months);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> months = databaseAccess.getMonthsOfSowing();
        databaseAccess.close();
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, months);
        this.list4.setAdapter(adapter4);

        //Retrieving 'Season' from database
        list5 = (ListView) findViewById(R.id.season);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> season = databaseAccess.getSeasonOfSowing();
        databaseAccess.close();
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, season);
        this.list5.setAdapter(adapter5);

        //Retrieving 'Weed Control' from database
        list6 = (ListView) findViewById(R.id.weed);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> weedControl = databaseAccess.getWeedControl();
        databaseAccess.close();
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, weedControl);
        this.list6.setAdapter(adapter6);

        //Retrieving 'Disease Control' from database
        list7 = (ListView) findViewById(R.id.disease);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> diseaseControl = databaseAccess.getDiseaseControl();
        databaseAccess.close();
        ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, diseaseControl);
        this.list7.setAdapter(adapter7);

        //Retrieving 'Insect Control' from database
        list8 = (ListView) findViewById(R.id.insect);
        databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();
        List<String> insectControl = databaseAccess.getInsectControl();
        databaseAccess.close();
        ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, insectControl);
        this.list8.setAdapter(adapter8);
    }
}