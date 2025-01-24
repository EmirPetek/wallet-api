package com.emirpetek.walletapp.walletApp.controller;

import com.emirpetek.walletapp.walletApp.dto.request.CreateTransactionRequest;
import com.emirpetek.walletapp.walletApp.dto.request.LoadBalanceRequest;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import com.emirpetek.walletapp.walletApp.service.PaymentService;
import com.emirpetek.walletapp.walletApp.service.TransactionService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;
    private final PaymentService paymentService;

    public TransactionController(TransactionService transactionService, PaymentService paymentService) {
        this.transactionService = transactionService;
        this.paymentService = paymentService;
    }

    @PostMapping("saveTransaction")
    public ResponseEntity<Boolean> saveTransaction(@RequestBody CreateTransactionRequest createTransactionRequest){
        return ResponseEntity.ok(transactionService.saveTransaction(createTransactionRequest));
    }

    @GetMapping("getTransactions/{userID}")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable Long userID){
        return ResponseEntity.ok(transactionService.getTransactions(userID));
    }


    @GetMapping("payBill/{userID}")
    public ResponseEntity<Boolean> payBill(@PathVariable Long userID){
        return ResponseEntity.ok(paymentService.payRandomBill(userID));
    }


    @GetMapping("randomPayment/{userID}")
    public ResponseEntity<Boolean> randomPayment(@PathVariable Long userID){
        return ResponseEntity.ok(paymentService.createRandomPayment(userID));
    }

    @GetMapping("getNumberOfTransactions/{userID}")
    public ResponseEntity<Integer> getNumberOfTransactions(@PathVariable Long userID){
        return ResponseEntity.ok(transactionService.getTransactions(userID).size());
    }


}
