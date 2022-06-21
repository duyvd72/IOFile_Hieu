package com.example.qlcv_externalfile.model;

import java.io.Serializable;

public class Staff implements Serializable {
    private int id;
    private String name, dob, country, level;
    public static int sma = 100;

    public Staff(String name, String dob, String country, String level) {
        this.id = sma;
        this.name = name;
        this.dob = dob;
        this.country = country;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", country='" + country + '\'' +
                ", level='" + level + '\'' +
                '}';
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Staff.sma = sma;
    }
}
