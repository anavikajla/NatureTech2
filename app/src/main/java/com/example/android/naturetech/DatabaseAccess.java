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

        String query = "SELECT * FROM Names";
        Cursor cursor = database.rawQuery(query, null);

        veg = new String[cursor.getCount()];

        int i = 0;

        while (cursor.moveToNext()) {
            veg[i] = cursor.getString(0); //0 = column for veggie name
            listOfVegetableNames.add(veg[i]);
            i++;
        }
        cursor.close();
        return listOfVegetableNames;
    }

    /* queries seed rate */
    public List<String> getVegetableSeedRate() {
        List<String> seedRate = new ArrayList<>();
        String[] veg;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor seedRateCursor = database.rawQuery(query, null);

        veg = new String[seedRateCursor.getCount()];

        int i = 0;

        while (seedRateCursor.moveToNext()) {
            veg[i] = seedRateCursor.getString(3); //3 = column for seedrate
            seedRate.add(veg[i]);
            i++;
        }

        seedRateCursor.close();
        return seedRate;
    }

    /**
     * queries transplanting
     */
    public List<String> getVegetableTransplanting() {
        List<String> transplanting = new ArrayList<>();
        String[] veg;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor transplantCursor = database.rawQuery(query, null);

        veg = new String[transplantCursor.getCount()];

        int i = 0;

        while (transplantCursor.moveToNext()) {
            veg[i] = transplantCursor.getString(4); //4 = column for transplanting
            transplanting.add(veg[i]);
            i++;
        }

        transplantCursor.close();
        return transplanting;
    }

    /**
     * queries spacing
     */
    public List<String> getSeedSpacing() {
        List<String> spacing = new ArrayList<>();
        String[] space;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor spacingCursor = database.rawQuery(query, null);

        space = new String[spacingCursor.getCount()];

        int i = 0;

        while (spacingCursor.moveToNext()) {
            space[i] = spacingCursor.getString(5); //5 = column for spacing
            spacing.add(space[i]);
            i++;
        }

        spacingCursor.close();
        return spacing;
    }

    /**
     * queries months
     */
    public List<String> getMonthsOfSowing() {
        List<String> months = new ArrayList<>();
        String[] month;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor spacingCursor = database.rawQuery(query, null);

        month = new String[spacingCursor.getCount()];

        int i = 0;

        while (spacingCursor.moveToNext()) {
            month[i] = spacingCursor.getString(6); //6 = column for months
            months.add(month[i]);
            i++;
        }

        spacingCursor.close();
        return months;
    }

    /**
     * queries season
     */
    public List<String> getSeasonOfSowing() {
        List<String> season = new ArrayList<>();
        String[] month;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor spacingCursor = database.rawQuery(query, null);

        month = new String[spacingCursor.getCount()];

        int i = 0;

        while (spacingCursor.moveToNext()) {
            month[i] = spacingCursor.getString(7); //7 = column for season
            season.add(month[i]);
            i++;
        }

        spacingCursor.close();
        return season;
    }

    /**
     * queries weed-control method
     */
    public List<String> getWeedControl() {
        List<String> weedControlMethods = new ArrayList<>();
        String[] weedControl;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor weedControlCursor = database.rawQuery(query, null);

        weedControl = new String[weedControlCursor.getCount()];

        int i = 0;

        while (weedControlCursor.moveToNext()) {
            weedControl[i] = weedControlCursor.getString(8); //8 = column for weed-control method
            weedControlMethods.add(weedControl[i]);
            i++;
        }

        weedControlCursor.close();
        return weedControlMethods;
    }

    /**
     * queries disease control method
     */
    public List<String> getDiseaseControl() {
        List<String> diseaseControlMethods = new ArrayList<>();
        String[] diseaseControl;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor diseaseControlCursor = database.rawQuery(query, null);

        diseaseControl = new String[diseaseControlCursor.getCount()];

        int i = 0;

        if (diseaseControlCursor.getCount() > 0) {
            while (diseaseControlCursor.moveToNext()) {
                diseaseControl[i] = diseaseControlCursor.getString(9); //10 = column for disease control
                diseaseControlMethods.add(diseaseControl[i]);
                i++;
            }
        }

        diseaseControlCursor.close();
        return diseaseControlMethods;
    }

    /**
     * queries insect control method
     */
    public List<String> getInsectControl() {
        List<String> insectControlMethods = new ArrayList<>();
        String[] insectControl;
        String vegetable = KnowledgeCentre.vegSelection;
        String seedType = KnowledgeCentre.seedTypeSelection;

        String query = "SELECT * FROM Vegetables WHERE Veg_Name=\"" + vegetable + "\" AND Seed_Type=\"" + seedType + "\"";
        Cursor insectControlCursor = database.rawQuery(query, null);

        insectControl = new String[insectControlCursor.getCount()];

        int i = 0;

        while (insectControlCursor.moveToNext()) {
            insectControl[i] = insectControlCursor.getString(10); //11 = column for insect control
            insectControlMethods.add(insectControl[i]);
            i++;
        }

        insectControlCursor.close();
        return insectControlMethods;
    }
}
