package com.emirpetek.walletapp.walletApp.service;

import com.emirpetek.walletapp.walletApp.dto.CardDTO;
import com.emirpetek.walletapp.walletApp.dto.TransactionDTO;
import com.emirpetek.walletapp.walletApp.dto.request.CreateTransactionRequest;
import com.emirpetek.walletapp.walletApp.dto.request.LoadBalanceRequest;
import com.emirpetek.walletapp.walletApp.model.BillType;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import com.emirpetek.walletapp.walletApp.repository.TransactionRepository;
import com.emirpetek.walletapp.walletApp.util.RandomBill;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Service
public class TransactionService {


    private final TransactionRepository transactionRepository;


    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Boolean saveTransaction(CreateTransactionRequest createTransactionRequest){
        try{
            Transaction transaction = new Transaction(
                    createTransactionRequest.getUserId(),
                    createTransactionRequest.getTransactionType(),
                    createTransactionRequest.getTransactionDirection(),
                    createTransactionRequest.getAmount(),
                    createTransactionRequest.getCurrency(),
                    createTransactionRequest.getTransactionDate(),
                    createTransactionRequest.getDescription(),
                    createTransactionRequest.getTransferReceiverUserId(),
                    createTransactionRequest.getTransactionCardId()
            );
            transactionRepository.save(transaction);
            return true;
        } catch (Exception e) {
            System.err.println("Error saving transaction: " + e.getMessage());
            return false;
        }
    }

    public List<Transaction> getTransactions(Long userID){
        return transactionRepository.getTransactions(userID);
    }




}
