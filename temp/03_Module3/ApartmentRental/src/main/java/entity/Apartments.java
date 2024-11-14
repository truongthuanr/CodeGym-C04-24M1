package entity;

import java.util.Date;

public class Apartments {
    private int id;
    private String name;
    private String tel;
    private Date startdate;
    private String paytype;
    private String note;

    public Apartments() {

    }
    public Apartments(int id, String name, String tel, Date startdate, String paytype, String note) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.startdate = startdate;
        this.paytype = paytype;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public String getTel() {
        return this.tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
