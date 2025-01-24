package com.emirpetek.walletapp.walletApp.dto.converter;

import com.emirpetek.walletapp.walletApp.dto.AccountDTO;
import com.emirpetek.walletapp.walletApp.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {

    public AccountDTO AccountDtoConverter(Account from){
        return new AccountDTO(
                from.getId(),
                from.getAccountNumber(),
                from.getBalance(),
                from.getCurrency(),
                from.getUserID()
        );
    }


}
