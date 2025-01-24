package com.emirpetek.walletapp.walletApp.service;


import com.emirpetek.walletapp.walletApp.dto.CardDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.CardDtoConverter;
import com.emirpetek.walletapp.walletApp.dto.request.CreateCardRequest;
import com.emirpetek.walletapp.walletApp.dto.request.CreateTransactionRequest;
import com.emirpetek.walletapp.walletApp.dto.request.LoadBalanceRequest;
import com.emirpetek.walletapp.walletApp.dto.request.WithdrawMoneyRequest;
import com.emirpetek.walletapp.walletApp.model.Card;
import com.emirpetek.walletapp.walletApp.model.Transaction;
import com.emirpetek.walletapp.walletApp.repository.CardRepository;
import com.emirpetek.walletapp.walletApp.util.account.CreateAccountInformation;
import com.emirpetek.walletapp.walletApp.util.cardInformation.GetCardInformation;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    private final CardRepository cardRepository;
    private final CardDtoConverter converter;
    private final TransactionService transactionService;


    public CardService(CardRepository cardRepository, CardDtoConverter converter, TransactionService transactionService) {
        this.cardRepository = cardRepository;
        this.converter = converter;
        this.transactionService = transactionService;
    }

    public boolean createValidCard(CreateCardRequest createCardRequest) {

        try {
            Card card = new Card(
                    new GetCardInformation().getCardNumber(),
                    createCardRequest.getCardHolder(),
                    new GetCardInformation().getExpireDate(),
                    new GetCardInformation().getCvvNumber(),
                    createCardRequest.getCardType(),
                    createCardRequest.getUserID(),
                    System.currentTimeMillis(),
                    new CreateAccountInformation().generateAccountNumber(),
                    createCardRequest.getBalance(),
                    createCardRequest.getCurrencyType());

            cardRepository.save(card);
            return true; // Kayıt başarılı
        } catch (Exception e) {
            System.err.println("Error saving card: " + e.getMessage());
            return false; // Kayıt başarısız
        }
    }


    public List<CardDTO> getCardInfo(Long userID){
            return
                cardRepository
                .getCardInfoFromUserAndAccountID(userID)
                .stream()
                .map(converter::CardInformationDtoConverter)
                .collect(Collectors.toList());
    }


    public Boolean isIbanValid(String ibanNumber){
        return cardRepository.isIbanNumberValidCount(ibanNumber) == 1;
    }

    public Card.CurrencyType getCardCurrencyType(String ibanNumber) { return cardRepository.getCardCurrencyType(ibanNumber); }

    public Boolean transferAmountBetweenCards(
            String receiverIbanNumber,
            String senderIbanNumber,
            BigDecimal amount
    ){
        int decreased = cardRepository.decreaseBalance(senderIbanNumber, amount);
        int increased = cardRepository.increaseBalance(receiverIbanNumber, amount);

        return decreased > 0 && increased > 0;
    }

    public Long getUserIdFromIbanNumber(String ibanNumber){ return cardRepository.getUserIdFromIbanNumber(ibanNumber); }

    public Long getCardIdFromIbanNumber(String ibanNumber){ return cardRepository.getCardIdFromIbanNumber(ibanNumber); }

    public String getIbanNumberFromCardId(Long id) { return cardRepository.getIbanNumberFromCardId(id); }

    public Card.CurrencyType getCardCurrencyTypeFromCardId(Long id){ return cardRepository.getCardCurrencyTypeFromCardId(id); }

    public Boolean decreaseBalance(String ibanNumber, BigDecimal amount) { return cardRepository.decreaseBalance(ibanNumber,amount) > 0;}


    public Boolean loadBalance(LoadBalanceRequest loadBalanceRequest){

        int isIncreased = cardRepository.increaseBalance(
            cardRepository.getIbanNumberFromCardId(loadBalanceRequest.getCardID()),
            loadBalanceRequest.getAmount());

        if (isIncreased > 0){
            Boolean isSaved = transactionService.saveTransaction(
                    new CreateTransactionRequest(
                            loadBalanceRequest.getUserID(),
                            Transaction.TransactionType.DEPOSIT,
                            Transaction.TransactionDirection.POSITIVE,
                            loadBalanceRequest.getAmount(),
                            cardRepository.getCardCurrencyTypeFromCardId(loadBalanceRequest.getCardID()),
                            System.currentTimeMillis(),
                            "",
                            loadBalanceRequest.getCardID()));
            if (isSaved) return true;
            else return false;
        }else return false;


    }


    public Boolean withdrawMoney(WithdrawMoneyRequest withdrawMoneyRequest){

        int isDecreased = cardRepository.decreaseBalance(
                cardRepository.getIbanNumberFromCardId(withdrawMoneyRequest.getCardID()),
                withdrawMoneyRequest.getAmount());

        if (isDecreased > 0){
            Boolean isSaved = transactionService.saveTransaction(
                    new CreateTransactionRequest(
                            withdrawMoneyRequest.getUserID(),
                            Transaction.TransactionType.WITHDRAWAL,
                            Transaction.TransactionDirection.NEGATIVE,
                            withdrawMoneyRequest.getAmount(),
                            cardRepository.getCardCurrencyTypeFromCardId(withdrawMoneyRequest.getCardID()),
                            System.currentTimeMillis(),
                            "",
                            withdrawMoneyRequest.getCardID()));
            return isSaved;
        }else return false;

    }





//    public List<CardAccountDTO> getCardAccountDto(Long accountID, Long userID){
//        return
//                cardRepository
//                        .getCardAccountDto(accountID,userID)
//                        .stream()
//                        .toList();
//    }


//    public CardDTO getCardInformationByID(Long id){
//        return converter.CardInformationDtoConverter(
//                cardRepository.findById(id.toString())
//                        .orElseThrow(() ->
//                                new CardNotFoundException("Card could not find by id: " + id.toString())));
//    }

//    public List<CardDTO> getAllCard() {
//        return cardRepository
//                .findAll()
//                .stream()
//                .map(converter::CardInformationDtoConverter)
//                .collect(Collectors.toList());
//    }


}
