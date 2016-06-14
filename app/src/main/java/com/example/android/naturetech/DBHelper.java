package com.example.android.naturetech;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anavikajla on 14/06/16.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Vegetables";
    public static final String VEGETABLES_TABLE_NAME = "vegetables_details";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "vegetable_name";
    public static final String KEY_SEASON = "season";
    public static final String KEY_LOCATION = "location";
    private static final int VEGETABLES_DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_VEGETABLES_TABLE = "CREATE TABLE " + VEGETABLES_TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SEASON + " TEXT," + KEY_LOCATION + " TEXT " + ")";
        db.execSQL(CREATE_VEGETABLES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + VEGETABLES_TABLE_NAME);
        // Creating tables again
        onCreate(db);
    }


    // code to get the single contact
    public List<Vegetable> getAllVegetables() {
        List<Vegetable> vegetableList = new ArrayList<Vegetable>();
        // Select All Query
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("SELECT * FROM vegetables_details", null);
//        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (res.moveToFirst()) {
            Vegetable veg = new Vegetable();
            veg.setId(Integer.parseInt(res.getString(0)));
            veg.setVegetableName(res.getString(1));
            veg.setSeason(res.getString(2));
            veg.setLocation(res.getString(3));
            // Adding contact to list
            vegetableList.add(veg);
            res.moveToNext();
        }
        res.close();
        // return contact list
        return vegetableList;
    }
}
