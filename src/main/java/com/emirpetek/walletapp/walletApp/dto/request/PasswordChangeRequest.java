package com.emirpetek.walletapp.walletApp.dto.request;

import com.emirpetek.walletapp.walletApp.model.PasswordResponse;

public class PasswordChangeRequest {

    private Long userID;
    private String oldPassword;
    private String newPassword;


    public PasswordChangeRequest(){}

    public PasswordChangeRequest(Long userID, String oldPassword, String newPassword) {
        this.userID = userID;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public PasswordChangeRequest(Long userID, String newPassword) {
        this.userID = userID;
        this.newPassword = newPassword;
    }


    public Long getUserID() {
        return userID;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }
}
