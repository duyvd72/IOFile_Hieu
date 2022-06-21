package com.example.qlcv_externalfile.model;

import java.io.Serializable;

public class Position implements Serializable {
    private int id;
    private String name, des;
    public static int sma = 100;

    public Position(String name, String des) {
        this.id = sma;
        this.name = name;
        this.des = des;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        Position.sma = sma;
    }
}
