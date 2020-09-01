package com.example.tutorials_utc;

public class Jobinfo {
    public Jobinfo() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }







    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Jobinfo(String header,  String des) {
        this.header = header;


        this.des = des;
    }

    private String header,des;
}
