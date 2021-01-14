package com.example.healthylife.models;

import java.util.Date;

public class User {
    private String username;
    private String email;
    private Date birthday;
    private GENDER gender;

    public User(String username, String email, Date birthday, GENDER gender) {
        this.username = username;
        this.email = email;
        this.birthday = birthday;
        this.gender = gender;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public GENDER getGender() {
        return gender;
    }

    public void setGender(GENDER gender) {
        this.gender = gender;
    }
}

