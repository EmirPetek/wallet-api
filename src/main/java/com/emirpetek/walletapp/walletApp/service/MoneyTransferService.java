package com.emirpetek.walletapp.walletApp.service;

import com.emirpetek.walletapp.walletApp.dto.request.CreateTransactionRequest;
import com.emirpetek.walletapp.walletApp.dto.request.SendMoneyRequest;
import com.emirpetek.walletapp.walletApp.model.MoneyTransfer;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MoneyTransferService {

    private final CardService cardService;
    private final TransactionService transactionService;
    private final UserService userService;


    public MoneyTransferService(CardService cardService, TransactionService transactionService, UserService userService) {
        this.cardService = cardService;
        this.transactionService = transactionService;
        this.userService = userService;
    }


    public MoneyTransfer.MoneyTransferReturnStatements MoneyTransfer(SendMoneyRequest sendMoneyRequest){

        if (sendMoneyRequest.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return MoneyTransfer.MoneyTransferReturnStatements.FAILURE_AMOUNT_LOWER_THAN_ZERO;
        }

        if(!cardService.isIbanValid(sendMoneyRequest.getReceiverIbanNumber())){
            return MoneyTransfer.MoneyTransferReturnStatements.FAILURE_INVALID_IBAN_NUMBER;
        }

        if (cardService.getCardCurrencyType(sendMoneyRequest.getReceiverIbanNumber()) != (sendMoneyRequest.getCurrencyType())){
            return MoneyTransfer.MoneyTransferReturnStatements.FAILURE_DIFFERENT_CURRENCY;
        }


        MoneyTransfer transfer = new MoneyTransfer();
        transfer.setSenderId(sendMoneyRequest.getSenderID());
        transfer.setSenderIbanNumber(sendMoneyRequest.getSenderIbanNumber());
        transfer.setReceiverIban(sendMoneyRequest.getReceiverIbanNumber());
        transfer.setAmount(sendMoneyRequest.getAmount());
        transfer.setCurrency(sendMoneyRequest.getCurrencyType());
        transfer.setTimestamp(System.currentTimeMillis());
        transfer.setDescription(sendMoneyRequest.getDescription());

        Long transferReceiverUserId = cardService.getUserIdFromIbanNumber(sendMoneyRequest.getReceiverIbanNumber());

        if (
                cardService.transferAmountBetweenCards(
                sendMoneyRequest.getReceiverIbanNumber(),
                sendMoneyRequest.getSenderIbanNumber(),
                sendMoneyRequest.getAmount())
        ){

            Long senderCardId = cardService.getCardIdFromIbanNumber(sendMoneyRequest.getSenderIbanNumber());
            Long receiverCardId = cardService.getCardIdFromIbanNumber(sendMoneyRequest.getReceiverIbanNumber());

            // save for sender
            Boolean transactionForSender = transactionService.saveTransaction(
                    new CreateTransactionRequest(
                            sendMoneyRequest.getSenderID(),
                            Transaction.TransactionType.TRANSFER,
                            Transaction.TransactionDirection.NEGATIVE,
                            sendMoneyRequest.getAmount(),
                            sendMoneyRequest.getCurrencyType(),
                            System.currentTimeMillis(),
                            sendMoneyRequest.getDescription(),
                            transferReceiverUserId,
                            senderCardId));

            // save for receiver
            Boolean transactionForReceiver = transactionService.saveTransaction(
                    new CreateTransactionRequest(
                            transferReceiverUserId,
                            Transaction.TransactionType.TRANSFER,
                            Transaction.TransactionDirection.POSITIVE,
                            sendMoneyRequest.getAmount(),
                            sendMoneyRequest.getCurrencyType(),
                            System.currentTimeMillis(),
                            sendMoneyRequest.getDescription(),
                            transferReceiverUserId,
                            receiverCardId));

            if (transactionForSender && transactionForReceiver){
                return MoneyTransfer.MoneyTransferReturnStatements.SUCCESSFUL_TRANSFER;
            }else {
                return MoneyTransfer.MoneyTransferReturnStatements.FAILURE_SERVER;
            }



        } else return MoneyTransfer.MoneyTransferReturnStatements.FAILURE_SERVER;



    }


}
