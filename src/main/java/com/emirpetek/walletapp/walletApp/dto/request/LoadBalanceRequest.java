package com.emirpetek.walletapp.walletApp.dto.request;

import java.math.BigDecimal;

public class LoadBalanceRequest {

    private Long userID;
    private BigDecimal amount;
    private Long cardID;


    public LoadBalanceRequest(Long userID, BigDecimal amount, Long cardID) {
        this.userID = userID;
        this.amount = amount;
        this.cardID = cardID;
    }

    public Long getUserID() {
        return userID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Long getCardID() {
        return cardID;
    }
}
