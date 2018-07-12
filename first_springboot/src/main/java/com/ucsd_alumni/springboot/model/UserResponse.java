package com.ucsd_alumni.springboot.model;

public class UserResponse {
    private String msg;

    public UserResponse() {

    }

    public UserResponse(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }

    
}
