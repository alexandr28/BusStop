package com.acampdev.busstop.Models;

import android.content.ContentValues;

import com.acampdev.busstop.SQLConstants;

public class User {
    private String id;
    private String email;
    private String password;

    public User(String id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContentValues toValues(){
        ContentValues contentValues= new ContentValues(3);
        contentValues.put(SQLConstants.COLUMN_ID,id);
        contentValues.put(SQLConstants.COLUMN_EMAIL,email);
        contentValues.put(SQLConstants.COLUMN_PASSWORD,password);
        return contentValues;
    }
}
