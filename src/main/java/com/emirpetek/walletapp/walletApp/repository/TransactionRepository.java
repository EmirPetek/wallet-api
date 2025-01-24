package com.emirpetek.walletapp.walletApp.repository;

import com.emirpetek.walletapp.walletApp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {


    @Query("SELECT t FROM Transaction t WHERE t.userId = :userId OR (t.userId = :userId AND t.transferReceiverUserId = :userId) ORDER BY t.transactionDate DESC")
    List<Transaction> getTransactions(@Param("userId") Long userId);




}
