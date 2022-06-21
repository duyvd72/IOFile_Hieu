package com.example.qlcv_externalfile.model;

import java.io.Serializable;

public class StaffPosition implements Serializable {
    private int id;
    private String createAt, des;
    private Staff staff;
    private Position position;
    public  static int sma = 100;

    public StaffPosition(String createAt, String des, Staff staff, Position position) {
        this.id = sma;
        this.createAt = createAt;
        this.des = des;
        this.staff = staff;
        this.position = position;
    }

    @Override
    public String toString() {
        return "StaffPosition{" +
                "id=" + id +
                ", createAt='" + createAt + '\'' +
                ", des='" + des + '\'' +
                ", staff=" + staff +
                ", position=" + position +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public static int getSma() {
        return sma;
    }

    public static void setSma(int sma) {
        StaffPosition.sma = sma;
    }
}
