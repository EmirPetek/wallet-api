package com.emirpetek.walletapp.walletApp.service;

import com.emirpetek.walletapp.walletApp.dto.AccountDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.AccountDtoConverter;
import com.emirpetek.walletapp.walletApp.model.Account;
import com.emirpetek.walletapp.walletApp.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;


    public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
    }

    public void createAccount(Account account){
        accountRepository.save(account);
    }

    public List<AccountDTO> getAccountByUserID(Long userID){
        return accountRepository.getAccountByUserID(userID).stream()
                .map(accountDtoConverter::AccountDtoConverter)
                .toList();
    }
}
