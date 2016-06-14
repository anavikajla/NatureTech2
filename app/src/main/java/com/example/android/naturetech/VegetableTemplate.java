package com.example.android.naturetech;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class VegetableTemplate extends Activity {

    ListView l;

    String[] veg;
    DatabaseAccess databaseAccess;
    DBHelper db;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetable_template);

        l = (ListView) findViewById(R.id.list1);

        this.databaseAccess = DatabaseAccess.getInstance(getApplicationContext());


        String irrigation, seed_rate, fertilizer;

//        databaseAccess = DatabaseAccess.getInstance(this);
//        databaseAccess.open();
//
//        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
//        databaseAccess.open();
//        List<Vegetable> quotes = databaseAccess.getVegetables();
//        databaseAccess.close();


//        Cursor cursor = database.rawQuery("SELECT * FROM vegetables_details", null);
//
//
//        List<String> array = new ArrayList<String>();
//        while (cursor.moveToNext()) {
//            String uname = cursor.getString(cursor.getColumnIndex("vegetable_name"));
//            array.add(uname);
//
//
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                array.add(cursor.getString(0));
//                array.add(cursor.getString(1));
//                cursor.moveToNext();
//            }
//            cursor.close();
//            // return array;
//

        //databaseAccess.close();

        db = new DBHelper(this);
        List<Vegetable> array_list = db.getAllVegetables();
        ArrayAdapter<Vegetable> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array_list);
        l.setAdapter(adapter);


        //List<Vegetable> vegetables = db.getAllVegetables();
        // Log.d("Reading: ", "Reading all shops..");
        //for (Vegetable veg : vegetables) {
        //  String information = "Id: " + veg.getId() + " ,Name: " + veg.getVegetableName() + " ,Season: " + veg.getSeason() + ",Address: " + veg.getLocation();
        // Writing shops to log
        //Log.d("Shop: : ", information);
        //}
    }
}
