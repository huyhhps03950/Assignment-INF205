package com.example.huy.assignment_inf205.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Huy on 04/16/2017.
 */
public class User implements Serializable{
    String username, password, name, address, sdt;
    Date birthday;
    ArrayList<order> userOrder = new ArrayList<>();
    public User(){

    }
    public User(String username, String password, String name, String address, String sdt, Date birthday){
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.sdt = sdt;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public ArrayList<order> getUserOrder() {
        return userOrder;
    }

    public void setUserOrder(ArrayList<order> userOrder) {
        this.userOrder = userOrder;
    }
}
