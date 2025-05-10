package com.example.mutation;

public class LoginService {
    public boolean authenticate(String username, String password) {
        if (username == null || password == null) return false;
        return username.equals("admin") && password.equals("secret");
    }
}
