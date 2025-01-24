package com.emirpetek.walletapp.walletApp.dto.request;

import com.emirpetek.walletapp.walletApp.model.Card;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateCardRequest {

    private Card.CardType cardType;
    private String cardHolder;
    private Long userID;
    private BigDecimal balance;
    private Card.CurrencyType currencyType;

    public CreateCardRequest(Card.CardType cardType, String cardHolder, Long userID, BigDecimal balance, Card.CurrencyType currencyType) {
        this.cardType = cardType;
        this.cardHolder = cardHolder;
        this.userID = userID;
        this.balance = balance;
        this.currencyType = currencyType;
    }

    public Card.CardType getCardType() {
        return cardType;
    }

    public void setCardType(Card.CardType cardType) {
        this.cardType = cardType;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Card.CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Card.CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    /*
    private Card card;

    public CreateCardRequest(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    */
}
