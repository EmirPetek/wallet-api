package com.emirpetek.walletapp.walletApp.dto.request;

import com.emirpetek.walletapp.walletApp.model.User;

public class RegisterRequest {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "user=" + user +
                '}';
    }
}
