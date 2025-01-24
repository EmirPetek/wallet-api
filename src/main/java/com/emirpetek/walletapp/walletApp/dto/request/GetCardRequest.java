package com.emirpetek.walletapp.walletApp.dto.request;

public class GetCardRequest {

    private Long userID;
    private Long accountID;

    public GetCardRequest(Long userID, Long accountID) {
        this.userID = userID;
//        this.accountID = accountID;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }
}
