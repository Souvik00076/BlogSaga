package com.example.blogsaga.utils.models;

public class UserToken {
    private String email, password;

    public UserToken(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
