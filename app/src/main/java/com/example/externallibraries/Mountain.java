package com.example.externallibraries;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Mountain {
    String name;
    String location;
    @SerializedName("size")
    int height;
    WikiData auxdata;



    Mountain() {
        name = "No name given";
        location = "No location given";
        height = -1; // signifies no height known

    }

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", height=" + height +
                ", auxdata=" + auxdata +
                '}';
    }
}
