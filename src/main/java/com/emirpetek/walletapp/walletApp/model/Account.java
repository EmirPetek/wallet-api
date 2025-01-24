package com.emirpetek.walletapp.walletApp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT için kullanılır
    private Integer id;

    @Column(name = "accountNumber")
    private String accountNumber; // Benzersiz hesap numarası

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO; // Hesap bakiyesi, varsayılan olarak 0.00

    @Column(name = "currency")
    private String currency = "TRY"; // Para birimi, varsayılan olarak 'TRY'

    @Column(name = "userID") // Foreign key tanımı
    private Integer userID; // Hesap sahibini temsil eder

    @Column(name = "createdAt")
    private Long createdAt = System.currentTimeMillis(); // Hesap oluşturulma zamanı

    public Account(){}

    public Account( String accountNumber, BigDecimal balance, String currency, Integer userID, Long createdAt) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.userID = userID;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
