package com.example.android.naturetech;

/**
 * Created by anavikajla on 14/06/16.
 */
public class Vegetable {

    private int id;
    private String vegetableName;
    private String season;
    private String location;

    public Vegetable() {

    }

    public Vegetable(int vegId, String vegetable_name, String season, String location) {
        super();
        this.id = vegId;
        this.vegetableName = vegetable_name;
        this.season = season;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
