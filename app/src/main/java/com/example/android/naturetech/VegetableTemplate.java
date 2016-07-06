package com.example.android.naturetech;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;

import java.util.List;

public class VegetableTemplate extends Activity {

    ListView list, list2, list3, list4, list5, list6, list7, list8;
    Button irrigation, fertilization, close, close2;
    DatabaseAccess databaseAccess;
    PopupWindow popUpIrrigation, popUpFertilization;
    LinearLayout popUpLayout, popUpLayout2;
    TextView popUpText, popUpText2;
    Boolean click = true;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

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




       /* irrigation = (Button) findViewById(R.id.irrigation);
        popUpIrrigation = new PopupWindow(this);

        irrigation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(click){
                    popUpIrrigation.showAtLocation(popUpLayout, Gravity.BOTTOM, 10,10);
                    popUpIrrigation.update(50,50, 300, 80);
                    click = false;
                }

                else{
                    popUpIrrigation.dismiss();
                    click = true;
                }
            }
        });


        //fertilization schedule
        fertilization = (Button) findViewById(R.id.fertilization);
        popUpFertilization = new PopupWindow(this);

        fertilization.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(click){
                    popUpFertilization.showAtLocation(popUpLayout, Gravity.BOTTOM, 10,10);
                    popUpFertilization.update(50,50, 300, 80);
                    click = false;
                }

                else{
                    popUpFertilization.dismiss();
                    click = true;
                }
            }
        });

        irrigation.setText("Such and such");
        popUpIrrigation.setContentView(main);
        popUpLayout.addView(fertilization);
        setContentView(popUpLayout);*/
        init();
        popUpInit();
    }

    public void init() {

        //irrigation schedule
        irrigation = (Button) findViewById(R.id.irrigation);
        popUpText = new TextView(this);
        close = new Button(this);
        popUpLayout = new LinearLayout(this);
        close.setText("Ok");
        popUpText.setText("Irrigation info");
        popUpText.setPadding(0, 0, 0, 20);
        popUpLayout.setOrientation(LinearLayout.VERTICAL);
        popUpLayout.addView(popUpText);
        popUpLayout.addView(close);

        //fertilization schedule
        fertilization = (Button) findViewById(R.id.fertilization);
        popUpText2 = new TextView(this);
        close2 = new Button(this);
        popUpLayout2 = new LinearLayout(this);
        close2.setText("Ok");
        popUpText2.setText("Fertilization info");
        popUpText2.setPadding(0, 0, 0, 20);
        popUpLayout2.setOrientation(LinearLayout.VERTICAL);
        popUpLayout2.addView(popUpText2);
        popUpLayout2.addView(close2);
    }

    public void popUpInit() {
        popUpIrrigation = new PopupWindow(popUpLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popUpIrrigation.setContentView(popUpLayout);

        irrigation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.irrigation) {
                    popUpIrrigation.showAsDropDown(irrigation, 0, 0);
                } else {
                    popUpIrrigation.dismiss();
                }
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click) {
                    popUpIrrigation.dismiss();
                }
            }
        });

        popUpFertilization = new PopupWindow(popUpLayout2, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popUpFertilization.setContentView(popUpLayout2);

        fertilization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.fertilization) {
                    popUpFertilization.showAsDropDown(fertilization, 0, 0);
                } else {
                    popUpFertilization.dismiss();
                }
            }
        });

        close2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click) {
                    popUpFertilization.dismiss();
                }
            }
        });
    }
}