package com.emirpetek.walletapp.walletApp.dto;

import com.emirpetek.walletapp.walletApp.model.Card;

import java.math.BigDecimal;

public class CardAccountDTO {
        private Long cardID;
        private String cardNumber;
        private String cardHolder;
        private String expireDate;
        private Integer cvv;
        private Card.CardType cardType;
        private Long userID;
        private Integer accountID;
        private String accountNumber;
        private BigDecimal balance;
        private String currency;

    public CardAccountDTO(Long cardID, String cardNumber, String cardHolder, String expireDate, Integer cvv, Card.CardType cardType, Long userID, Integer accountID, String accountNumber, BigDecimal balance, String currency) {
        this.cardID = cardID;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.cardType = cardType;
        this.userID = userID;
        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
    }

    public CardAccountDTO() {
    }


    public Long getCardID() {
        return cardID;
    }

    public void setCardID(Long cardID) {
        this.cardID = cardID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Card.CardType getCardType() {
        return cardType;
    }

    public void setCardType(Card.CardType cardType) {
        this.cardType = cardType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
