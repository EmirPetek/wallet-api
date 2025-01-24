package com.emirpetek.walletapp.walletApp.dto;

import com.emirpetek.walletapp.walletApp.model.Card;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;

public class CardDTO {

    public Long id;
    public String cardNumber;
    public String cardHolder;
    public String expireDate;
    public Integer cvv;
    public Card.CardType cardType;
    public Long userID;
    public String accountID;
    public BigDecimal balance ;// Hesap bakiyesi, varsayılan olarak 0.00
    public Card.CurrencyType currency ; // Para birimi, varsayılan olarak 'TRY'


    public CardDTO(Long id, String cardNumber, String cardHolder, String expireDate, Integer cvv, Card.CardType cardType, Long userID, String accountID, BigDecimal balance, Card.CurrencyType currency) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.cardType = cardType;
        this.userID = userID;
        this.accountID = accountID;
        this.balance = balance;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "id=" + id +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardHolder='" + cardHolder + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", cvv=" + cvv +
                ", cardType=" + cardType +
                ", userID=" + userID +
                ", accountID='" + accountID + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                '}';
    }
}
