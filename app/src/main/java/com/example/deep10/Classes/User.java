package com.example.deep10.Classes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class User implements SqlInterface{

    // region Attribute
    private String uid;
    private String username ;
    private String email;
    private String password;
    //endregion

    //region Cunstructors
    public User(String uid,String username,String email,String password){
        this.uid = uid;
        this.username= username;
        this.email=email;
        this.password=password;
    }
    //endregion

    //region Add,Delete,Update,Select sql
    @Override
    public long Add(SQLiteDatabase db) {
        return 0;
    }

    @Override
    public int Delete(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public int Update(SQLiteDatabase db, int id) {
        return 0;
    }

    @Override
    public Cursor Select(SQLiteDatabase db) {
        return null;
    }

    //endregion

    //region Setter and Getter
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    //endregion
}
