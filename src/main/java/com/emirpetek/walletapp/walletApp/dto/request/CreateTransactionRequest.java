package com.emirpetek.walletapp.walletApp.dto.request;

import com.emirpetek.walletapp.walletApp.model.Card;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import com.emirpetek.walletapp.walletApp.model.Transaction.TransactionType;

import java.math.BigDecimal;

public class CreateTransactionRequest {

    private Long userId; // İşlemi yapan kullanıcının ID'si
    private TransactionType transactionType; // İşlem türü (enum)
    private Transaction.TransactionDirection transactionDirection;
    private BigDecimal amount; // İşlem tutarı
    private Card.CurrencyType currency; // Para birimi (ör. TRY, USD)
    private Long transactionDate; // İşlem tarihi (timestamp formatında)
    private String description; // İşlem açıklaması (opsiyonel)
    private Long transferReceiverUserId;
    private Long transactionCardId;

    // Constructor
    public CreateTransactionRequest() {}

    public CreateTransactionRequest(Long userId, TransactionType transactionType, Transaction.TransactionDirection transactionDirection, BigDecimal amount, Card.CurrencyType currency, Long transactionDate, String description, Long transactionCardId) {
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionDirection = transactionDirection;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.description = description;
        this.transactionCardId = transactionCardId;
    }

    public CreateTransactionRequest(Long userId, TransactionType transactionType, Transaction.TransactionDirection transactionDirection, BigDecimal amount, Card.CurrencyType currency, Long transactionDate, String description, Long transferReceiverUserId, Long transactionCardId) {
        this.userId = userId;
        this.transactionType = transactionType;
        this.transactionDirection = transactionDirection;
        this.amount = amount;
        this.currency = currency;
        this.transactionDate = transactionDate;
        this.description = description;
        this.transferReceiverUserId = transferReceiverUserId;
        this.transactionCardId = transactionCardId;;
    }

    public Transaction.TransactionDirection getTransactionDirection() {
        return transactionDirection;
    }

    public void setTransactionDirection(Transaction.TransactionDirection transactionDirection) {
        this.transactionDirection = transactionDirection;
    }

    // Getters and Setters
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

