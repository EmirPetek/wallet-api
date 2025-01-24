package com.emirpetek.walletapp.walletApp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table//(name = "Transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "transactionType")
    private TransactionType transactionType;

    @Column(name = "transactionDirection")
    private TransactionDirection transactionDirection;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "currency")
    private Card.CurrencyType currency;

    @Column(name = "transactionDate")
    private Long transactionDate;

    @Column(name = "description")
    private String description;

    @Column(name = "transferReceiverUserId")
    private Long transferReceiverUserId;

    @Column(name = "transactionCardId")
    private Long transactionCardId;




    public enum TransactionType{
        PAYMENT,                   // Ödeme
        TRANSFER,                 // Para Gönderme
        DEPOSIT,                   // Cüzdana Para Yükleme
        WITHDRAWAL,             // Para Çekme
        BILL_PAYMENT,         // Fatura Ödeme
    }

    public enum TransactionDirection{
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    public Transaction(){}

    public Transaction(Long id, Long userId, TransactionType transactionType, TransactionDirection transactionDirection, BigDecimal amount, Card.CurrencyType currency, Long transactionDate, String description, Long transferReceiverUserId) {
        this.id = id;
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionDirection = transactionDirection;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.description = description;
        this.transferReceiverUserId = transferReceiverUserId;
    }

    public Transaction(Long userId, TransactionType transactionType, TransactionDirection transactionDirection, BigDecimal amount, Card.CurrencyType currency, Long transactionDate, String description, Long transferReceiverUserId, Long transactionCardId) {
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionDirection = transactionDirection;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.description = description;
        this.transferReceiverUserId = transferReceiverUserId;
        this.transactionCardId = transactionCardId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Card.CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(Card.CurrencyType currency) {
        this.currency = currency;
    }

    public TransactionDirection getTransactionDirection() {
        return transactionDirection;
    }

    public void setTransactionDirection(TransactionDirection transactionDirection) {
        this.transactionDirection = transactionDirection;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Long transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTransferReceiverUserId() {
        return transferReceiverUserId;
    }

    public void setTransferReceiverUserId(Long transferReceiverUserId) {
        this.transferReceiverUserId = transferReceiverUserId;
    }

    public Long getTransactionCardId() {
        return transactionCardId;
    }

    public void setTransactionCardId(Long transactionCardId) {
        this.transactionCardId = transactionCardId;
    }
}
