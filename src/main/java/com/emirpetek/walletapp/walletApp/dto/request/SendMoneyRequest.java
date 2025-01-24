package com.emirpetek.walletapp.walletApp.dto.request;

import com.emirpetek.walletapp.walletApp.model.Card;

import java.math.BigDecimal;

public class SendMoneyRequest {

    private Long senderID;
    private String senderIbanNumber;
    private String receiverIbanNumber;
    private BigDecimal amount;
    private Card.CurrencyType currencyType;
    private String description;

    public SendMoneyRequest(Long senderID, String senderIbanNumber, String receiverIbanNumber, BigDecimal amount, Card.CurrencyType currencyType, String description) {
        this.senderID = senderID;
        this.senderIbanNumber = senderIbanNumber;
        this.receiverIbanNumber = receiverIbanNumber;
        this.amount = amount;
        this.currencyType = currencyType;
        this.description = description;
    }

    public Long getSenderID() {
        return senderID;
    }

    public void setSenderID(Long senderID) {
        this.senderID = senderID;
    }

    public String getSenderIbanNumber() {
        return senderIbanNumber;
    }

    public void setSenderIbanNumber(String senderIbanNumber) {
        this.senderIbanNumber = senderIbanNumber;
    }

    public String getReceiverIbanNumber() {
        return receiverIbanNumber;
    }

    public void setReceiverIbanNumber(String receiverIbanNumber) {
        this.receiverIbanNumber = receiverIbanNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Card.CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Card.CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
