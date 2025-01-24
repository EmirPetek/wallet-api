package com.emirpetek.walletapp.walletApp.service;

import com.emirpetek.walletapp.walletApp.dto.CardDTO;
import com.emirpetek.walletapp.walletApp.dto.request.CreateTransactionRequest;
import com.emirpetek.walletapp.walletApp.model.BillType;
import com.emirpetek.walletapp.walletApp.model.PaymentCompany;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import com.emirpetek.walletapp.walletApp.util.RandomBill;
import com.emirpetek.walletapp.walletApp.util.RandomPayment;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;

@Service
public class PaymentService {

    private final CardService cardService;
    private final TransactionService transactionService;

    public PaymentService(CardService cardService, TransactionService transactionService) {
        this.cardService = cardService;
        this.transactionService = transactionService;
    }

    public Boolean createRandomPayment(Long userID){
        PaymentCompany randomPaymentCompany = RandomPayment.getRandomPaymentCompany();

        // select random card
        List<CardDTO> cards = cardService.getCardInfo(userID);
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        CardDTO card = cards.get(randomIndex);

        BigDecimal paymentAmount = getRandomAmount(card.balance, 0.2);

        Boolean isTransactionSuccessful = transactionService.saveTransaction(new CreateTransactionRequest(
                userID,
                Transaction.TransactionType.PAYMENT,
                Transaction.TransactionDirection.NEGATIVE,
                paymentAmount,
                cardService.getCardCurrencyTypeFromCardId(card.id),
                System.currentTimeMillis(),
                randomPaymentCompany.toString(),
                card.id));

        if (isTransactionSuccessful){
            if (cardService.decreaseBalance(cardService.getIbanNumberFromCardId(card.id),paymentAmount))
                return true;
            else return false;
        }else return false;


    }





    public Boolean payRandomBill(Long userID){
        BillType randomBill = RandomBill.getRandomBillType();

        // select random card
        List<CardDTO> cards = cardService.getCardInfo(userID);
        Random random = new Random();
        int randomIndex = random.nextInt(cards.size());
        CardDTO card = cards.get(randomIndex);

        BigDecimal paymentAmount = getRandomAmount(card.balance,0.05);




        Boolean isTransactionSuccessfull = transactionService.saveTransaction(new CreateTransactionRequest(
                userID,
                Transaction.TransactionType.BILL_PAYMENT,
                Transaction.TransactionDirection.NEGATIVE,
                paymentAmount,
                cardService.getCardCurrencyTypeFromCardId(card.id),
                System.currentTimeMillis(),
                randomBill.toString(),
                card.id));

        if (isTransactionSuccessfull){
            if (cardService.decreaseBalance(cardService.getIbanNumberFromCardId(card.id),paymentAmount))
                return true;
            else return false;
        }else return false;


    }

    public static BigDecimal getRandomAmount(BigDecimal balance, Double ratio) {
        // it returns the number that is lower than %0.05 of the current card balance
        BigDecimal maxAmount = balance.multiply(new BigDecimal(ratio));
        Random random = new Random();
        BigDecimal randomMultiplier = new BigDecimal(random.nextDouble());
        BigDecimal randomAmount = maxAmount.multiply(randomMultiplier);
        return randomAmount.setScale(2, RoundingMode.HALF_UP);
    }


}
