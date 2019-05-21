package com.example.handclassapp;

import org.litepal.crud.DataSupport;

public class Account extends DataSupport {

    private int ID;

    private String UserName;

    private String Pwd;


    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getPwd() {
        return Pwd;
    }
    public void setPwd(String pwd) {
        this.Pwd= pwd;
    }

}