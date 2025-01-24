package com.emirpetek.walletapp.walletApp.util.cardInformation;

public class GetCardInformation {

    public String getCardNumber(){
        return CreateCardInformation.generateCardNumber();
    }
    public String getExpireDate(){
        return CreateCardInformation.generateExpireDate();
    }
    public Integer getCvvNumber(){
        return CreateCardInformation.generateCvv();
    }

}
