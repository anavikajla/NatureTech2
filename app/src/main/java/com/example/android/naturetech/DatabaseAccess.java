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
public class DatabaseAccess {

    private static DatabaseAccess instance;
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;

    /**
     * Private constructor to avoid object creation from outside classes.
     *
     */

    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DatabaseAccess
     */
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all vegetables from the database "Vegetables.db" and table "vegetables_details".
     *
     * @return a List of vegetables
     */
    public List<String> getVegetables() {
        List<String> listOfVegetableNames = new ArrayList<>();
        String[] veg;

        Cursor cursor = database.rawQuery("SELECT * FROM vegetables_details", null);

        veg = new String[cursor.getCount()];

        int i = 0;

        while (cursor.moveToNext()) {
            veg[i] = cursor.getString(0); //1 = column for veggie name
            listOfVegetableNames.add(veg[i]);
            i++;
        }
        cursor.close();
        return listOfVegetableNames;
    }
}