package com.example.sep4_android.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Garden {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String ownerGoogleId;
    private String name;
    private double landArea;
    private String city;
    private String street;
    private String number;

    public Garden(String name, double landArea, String city, String street, String number, String ownerGoogleId) {
        this.name = name;
        this.landArea = landArea;
        this.city = city;
        this.street = street;
        this.number = number;
        this.ownerGoogleId = ownerGoogleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLandArea() {
        return landArea;
    }

    public void setLandArea(double landArea) {
        this.landArea = landArea;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getOwnerGoogleId() {
        return ownerGoogleId;
    }

    public void setOwnerGoogleId(String ownerGoogleId) {
        this.ownerGoogleId = ownerGoogleId;
    }
}
