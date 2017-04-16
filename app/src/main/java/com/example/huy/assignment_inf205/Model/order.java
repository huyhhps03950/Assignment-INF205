package com.example.huy.assignment_inf205.Model;

import java.util.Date;

/**
 * Created by Huy on 04/13/2017.
 */
public class order {
    String user, idbook;
    Date datebook, datesell;

    public order() {
    }

    public order(String user, String idbook, Date datebook, Date datesell) {
        this.user = user;
        this.idbook = idbook;
        this.datebook = datebook;
        this.datesell = datesell;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdbook() {
        return idbook;
    }

    public void setIdbook(String idbook) {
        this.idbook = idbook;
    }

    public Date getDatebook() {
        return datebook;
    }

    public void setDatebook(Date datebook) {
        this.datebook = datebook;
    }

    public Date getDatesell() {
        return datesell;
    }

    public void setDatesell(Date datesell) {
        this.datesell = datesell;
    }
}
