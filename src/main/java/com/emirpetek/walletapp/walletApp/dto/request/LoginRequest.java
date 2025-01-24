package com.emirpetek.walletapp.walletApp.dto.request;

public class LoginRequest {
    private String email;
    private String password;

    // Getter ve Setter metotları
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
}
