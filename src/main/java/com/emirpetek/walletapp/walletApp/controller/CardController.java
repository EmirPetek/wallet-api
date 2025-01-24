package com.emirpetek.walletapp.walletApp.controller;

import com.emirpetek.walletapp.walletApp.dto.CardDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.CardDtoConverter;
import com.emirpetek.walletapp.walletApp.dto.request.*;
import com.emirpetek.walletapp.walletApp.service.CardService;
import com.emirpetek.walletapp.walletApp.service.MoneyTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/card")
public class CardController {

    private final CardService cardService;
    private final CardDtoConverter cardDtoConverter;


    public CardController(CardService cardService, CardDtoConverter cardDtoConverter) {
        this.cardService = cardService;
        this.cardDtoConverter = cardDtoConverter;
    }

    @PostMapping("/createCard")
    public ResponseEntity<Boolean> createCard(@RequestBody CreateCardRequest createCardRequest){
        return ResponseEntity.ok(cardService.createValidCard(createCardRequest));
    }

    @PostMapping("/getCard")
    public ResponseEntity<List<CardDTO>> getCardInfo(@RequestBody GetCardRequest getCardRequest){
        return
                ResponseEntity.ok(cardService
                        .getCardInfo(getCardRequest.getUserID()));
    }

    @PostMapping("loadBalance")
    public ResponseEntity<Boolean> loadBalance(@RequestBody LoadBalanceRequest loadBalanceRequest){
        return ResponseEntity.ok(cardService.loadBalance(loadBalanceRequest));
    }

    @PostMapping("withdrawMoney")
    public ResponseEntity<Boolean> withdrawMoney(@RequestBody WithdrawMoneyRequest withdrawMoneyRequest){
        return ResponseEntity.ok(cardService.withdrawMoney(withdrawMoneyRequest));
    }


    @GetMapping("getNumberOfCards/{userID}")
    public ResponseEntity<Integer> getNumberOfCards(@PathVariable Long userID){
        return ResponseEntity.ok(cardService.getCardInfo(userID).size());
    }




//    @PostMapping("/getCardAccount")
//    public ResponseEntity<List<CardAccountDTO>> getCardAccountDto(@RequestBody GetCardRequest getCardRequest){
//        return
//                ResponseEntity.ok(cardService
//                        .getCardAccountDto(getCardRequest.getAccountID(),getCardRequest.getUserID())
//                        .stream().toList());
//    }







}
