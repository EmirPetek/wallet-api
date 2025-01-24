package com.emirpetek.walletapp.walletApp.repository;

import com.emirpetek.walletapp.walletApp.model.Card;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface CardRepository extends JpaRepository<Card,String> {


    @Query("SELECT c FROM Card c WHERE c.userID = :userID")
    List<Card> getCardInfoFromUserAndAccountID(@Param("userID") Long userID);

    @Query("SELECT COUNT(*) FROM Card c WHERE c.accountID = :accountID")
    Integer isIbanNumberValidCount(@Param("accountID") String accountID);



    @Query("SELECT currency FROM Card c WHERE c.accountID = :accountID")
    Card.CurrencyType getCardCurrencyType(String accountID);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.balance = c.balance + :amount WHERE c.accountID = :receiverAccountId")
    int increaseBalance(@Param("receiverAccountId") String receiverAccountId, @Param("amount") BigDecimal amount);

    @Modifying
    @Transactional
    @Query("UPDATE Card c SET c.balance = c.balance - :amount WHERE c.accountID = :senderAccountID")
    int decreaseBalance(@Param("senderAccountID") String senderAccountID, @Param("amount") BigDecimal amount);

    @Query("SELECT c.userID FROM Card c WHERE c.accountID = :accountID")
    Long getUserIdFromIbanNumber(@Param("accountID") String accountID);

    @Query("SELECT c.id FROM Card c WHERE c.accountID = :accountID")
    Long getCardIdFromIbanNumber(@Param("accountID") String accountID);

    @Query("SELECT c.accountID FROM Card c WHERE c.id = :id")
    String getIbanNumberFromCardId(@Param("id") Long id);

    @Query("SELECT c.currency FROM Card c WHERE c.id = :id")
    Card.CurrencyType getCardCurrencyTypeFromCardId(@Param("id") Long id);


//    @Query("SELECT new com.example.dto.CardAccountDTO(" +
//            "c.id, c.cardNumber, c.cardHolder, c.expireDate, c.cvv, c.cardType, c.userID, " +
//            "a.id, a.accountNumber, a.balance, a.currency) " +
//            "FROM Card c JOIN Account a ON c.accountID = a.id " +
//            "WHERE c.accountID = :accountID AND c.userID = :userID")
//    List<CardAccountDTO> getCardAccountDto(@Param("accountID") Long accountID, @Param("userID") Long userID);





}
