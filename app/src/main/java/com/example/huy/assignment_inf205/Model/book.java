package com.example.huy.assignment_inf205.Model;


import java.io.Serializable;

/**
 * Created by Huy on 04/13/2017.
 */
public class book implements Serializable{
    String idbook, theloai, namebook, tacgia;
    int sl;
    boolean status;
    public book() {
    }

    public book(String idbook, String theloai, String namebook, String tacgia, int sl, boolean status) {
        this.idbook = idbook;
        this.theloai = theloai;
        this.namebook = namebook;
        this.tacgia = tacgia;
        this.sl = sl;
        this.status = status;
    }

    public String getIdbook() {
        return idbook;
    }

    public void setIdbook(String idbook) {
        this.idbook = idbook;
    }

    public String getTheloai() {
        return theloai;
    }

    public void setTheloai(String theloai) {
        this.theloai = theloai;
    }

    public String getNamebook() {
        return namebook;
    }

    public void setNamebook(String namebook) {
        this.namebook = namebook;
    }

    public String getTacgia() {
        return tacgia;
    }

    public void setTacgia(String tacgia) {
        this.tacgia = tacgia;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
