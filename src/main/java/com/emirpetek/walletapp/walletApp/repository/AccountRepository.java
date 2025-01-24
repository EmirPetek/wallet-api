package com.emirpetek.walletapp.walletApp.repository;


import com.emirpetek.walletapp.walletApp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.userID = :userID")
    List<Account> getAccountByUserID(@Param("userID") Long userID);
}
