package com.emirpetek.walletapp.walletApp.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public class MoneyTransfer {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    //@Column(name = "senderId")
    private Long senderId; // Gönderici kullanıcı ID'si

    private String senderIbanNumber;

    //@Column(name = "receiverIban")
    private String receiverIban; // Alıcının IBAN numarası

    //@Column(name = "amount")
    private BigDecimal amount; // Transfer edilen tutar

    //@Column(name = "currency")
    private Card.CurrencyType currency; // Para birimi (ör. TRY, USD)

    //@Column(name = "timestamp")
    private Long timestamp; // Transfer tarihi

   // @Column(name = "description")
    private String description; // Transfer açıklaması (isteğe bağlı)


    public enum MoneyTransferReturnStatements{
        SUCCESSFUL_TRANSFER,
        FAILURE_AMOUNT_LOWER_THAN_ZERO,
        FAILURE_INVALID_IBAN_NUMBER,
        FAILURE_DIFFERENT_CURRENCY,
        FAILURE_SERVER
    }


    public MoneyTransfer() {
    }

    public MoneyTransfer(Long senderId, String senderIbanNumber, String receiverIban, BigDecimal amount, Card.CurrencyType currency, Long timestamp, String description) {
        this.senderId = senderId;
        this.senderIbanNumber = senderIbanNumber;
        this.receiverIban = receiverIban;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = timestamp;
        this.description = description;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public String getSenderIbanNumber() {
        return senderIbanNumber;
    }

    public void setSenderIbanNumber(String senderIbanNumber) {
        this.senderIbanNumber = senderIbanNumber;
    }

    public String getReceiverIban() {
        return receiverIban;
    }

    public void setReceiverIban(String receiverIban) {
        this.receiverIban = receiverIban;
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

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
