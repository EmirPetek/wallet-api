package com.emirpetek.walletapp.walletApp.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class TransactionDTO {

    private Long id;
    private Integer amount;
    private String description;
    private Long timestamp;
    private String cardID;
    private Long userID;

    public TransactionDTO(){}

    public TransactionDTO(Long id, Integer amount, String description, Long timestamp, String cardID, Long userID) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.cardID = cardID;
        this.userID = userID;
    }
}
