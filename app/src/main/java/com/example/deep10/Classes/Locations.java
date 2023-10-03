package com.example.deep10.Classes;

public class Locations {

    protected double latitude; // Changed data type to double for latitude
    protected double longitude; // Changed data type to double for longitude
    protected String locname;

    // Constructor
    public Locations(double latitude, double longitude, String locname) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.locname = locname;
    }

    // Getter and Setter methods for latitude, longitude, and locname
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getLocname() {
        return locname;
    }

    public void setLocname(String locname) {
        this.locname = locname;
    }
}
