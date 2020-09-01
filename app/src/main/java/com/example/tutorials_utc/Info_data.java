package com.example.tutorials_utc;




public class Info_data {
   private String header;
    private String hpic;

    public Info_data() {
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getHpic() {
        return hpic;
    }

    public void setHpic(String hpic) {
        this.hpic = hpic;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDpic() {
        return dpic;
    }

    public void setDpic(String dpic) {
        this.dpic = dpic;
    }

    public Info_data(String header, String hpic, String des, String code, String dpic) {
        this.header = header;
        this.hpic = hpic;
        this.des = des;
        this.code = code;
        this.dpic = dpic;
    }

    private String des;
    private String code;
    private String dpic;

}
