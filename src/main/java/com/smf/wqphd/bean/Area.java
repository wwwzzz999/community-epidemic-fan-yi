package com.smf.wqphd.bean;

public class Area {

    private int a_id;
    private String c_area;
    private String d_name;
    private int r_name;

    public Area(int a_id, String c_area, String d_name, int r_name) {
        this.a_id = a_id;
        this.c_area = c_area;
        this.d_name = d_name;
        this.r_name = r_name;
    }

    public Area() {
    }

    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getC_area() {
        return c_area;
    }

    public void setC_area(String c_area) {
        this.c_area = c_area;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public int getR_name() {
        return r_name;
    }

    public void setR_name(int r_name) {
        this.r_name = r_name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "a_id=" + a_id +
                ", c_area='" + c_area + '\'' +
                ", d_name='" + d_name + '\'' +
                ", r_name=" + r_name +
                '}';
    }
}
