package com.onlineauction.onlineauctionsale.model;

public class Signup_response {
    private String message_sucess;
    private String status;
    private String token;

    public Signup_response(String status, String token) {
        this.status = status;
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public Signup_response(String message_sucess) {
        this.message_sucess = message_sucess;
    }

    public String getMessage_sucess() {
        return message_sucess;
    }
}
