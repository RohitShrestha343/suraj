package com.onlineauction.onlineauctionsale.model;

public class Users {
    String first_name;
    String last_name;
    String gender;
    String email;
    String password;

    public Users(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Users(String first_name, String last_name, String gender, String email, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }
}
