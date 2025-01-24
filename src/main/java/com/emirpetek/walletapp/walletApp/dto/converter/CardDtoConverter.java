package com.emirpetek.walletapp.walletApp.dto.converter;


import com.emirpetek.walletapp.walletApp.dto.CardDTO;
import com.emirpetek.walletapp.walletApp.model.Card;
import org.springframework.stereotype.Component;

@Component
public class CardDtoConverter {


    public CardDTO CardInformationDtoConverter(Card from){
        return new CardDTO(
                from.getId(),
                from.getCardNumber(),
                from.getCardHolder(),
                from.getExpireDate(),
                from.getCvv(),
                from.getCardType(),
                from.getUserID(),
                from.getAccountID(),
                from.getBalance(),
                from.getCurrency()
        );
    }


}
