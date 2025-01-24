package com.emirpetek.walletapp.walletApp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table//(name = "Card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cardNumber")
    private String cardNumber;
    @Column(name = "cardHolder")
    private String cardHolder;
    @Column(name = "expireDate")
    private String expireDate;
    @Column(name = "cvv")
    private Integer cvv;
    @Column(name = "cardType")
    private CardType cardType;
    @Column(name = "userID")
    private Long userID;
    @Column(name = "createdAt")
    private long createdAt;
    @Column(name = "accountID")
    private String accountID;
    @Column(name = "balance")
    private BigDecimal balance; // Hesap bakiyesi, varsayılan olarak 0.00
    @Column(name = "currency")
    private CurrencyType currency; // Para birimi, varsayılan olarak 'TRY'




    public enum CurrencyType {
        TRY,
        EUR,
        USD
    }

    public enum CardType {
        VISA,
        MASTERCARD,
        MAESTRO,
        AMERICAN_EXPRESS,
        UNIONPAY,
        DINERS_CLUB,
    }

    public Card(String cardNumber, String cardHolder, String expireDate, Integer cvv, CardType cardType, Long userID, long createdAt, String accountID, BigDecimal balance, CurrencyType currency) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.cardType = cardType;
        this.userID = userID;
        this.createdAt = createdAt;
        this.accountID = accountID;
        this.balance = balance;
        this.currency = currency;
    }


    public Card(Long id, String cardNumber, String cardHolder, String expireDate, Integer cvv, CardType cardType, Long userID, long createdAt, String accountID, BigDecimal balance, CurrencyType currency) {
        this.id = id;
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.cardType = cardType;
        this.userID = userID;
        this.createdAt = createdAt;
        this.accountID = accountID;
        this.balance = balance;
        this.currency = currency;
    }

    public Card(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }
}
