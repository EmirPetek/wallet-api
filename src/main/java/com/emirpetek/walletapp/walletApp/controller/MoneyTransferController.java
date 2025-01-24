package com.emirpetek.walletapp.walletApp.controller;

import com.emirpetek.walletapp.walletApp.dto.request.SendMoneyRequest;
import com.emirpetek.walletapp.walletApp.model.MoneyTransfer;
import com.emirpetek.walletapp.walletApp.service.MoneyTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/transaction")
public class MoneyTransferController {

    private final MoneyTransferService moneyTransferService;

    public MoneyTransferController(MoneyTransferService moneyTransferService) {
        this.moneyTransferService = moneyTransferService;
    }


    @PostMapping("/moneyTransfer")
    public ResponseEntity<MoneyTransfer.MoneyTransferReturnStatements> moneyTransfer(@RequestBody SendMoneyRequest sendMoneyRequest){
        return  ResponseEntity.ok(moneyTransferService.MoneyTransfer(sendMoneyRequest));
    }

}
