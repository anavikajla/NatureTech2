package com.example.android.naturetech;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
     * @param context
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
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
//    public List<String> getQuotes() {
//        List<String> list = new ArrayList<>();
//        String[] veg;
//
//
//        Cursor cursor = database.rawQuery("SELECT * FROM vegetables_details", null);
//
////        veg = new String[cursor.getCount()];
////
////        int i = 0;
////
////        ArrayList<String> array = new ArrayList<String>();
////        while (cursor.moveToNext()) {
////            veg[i] = cursor.getString(0);
////
////
//           //i++;
//             cursor.moveToFirst();
//             while (!cursor.isAfterLast()) {
//
//             list.add(cursor.getString(0));
//              cursor.moveToNext();
//        }
//        cursor.close();
//        return list;
//
//
//    }

//    public List<Vegetable> getVegetables() {
//        List<Vegetable> list = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT * FROM vegetables_details", null);
//        cursor.moveToFirst();
//        while (!cursor.isAfterLast()) {
//            Vegetable contact = new Vegetable();
//            contact.setVegetableName(cursor.getString(0));
//            contact.setSeason(cursor.getString(1));
//            contact.setLocation(cursor.getString(2));
//            list.add(contact);
//            cursor.moveToNext();
//        }
//        cursor.close();
//        return list;
//    }
}
