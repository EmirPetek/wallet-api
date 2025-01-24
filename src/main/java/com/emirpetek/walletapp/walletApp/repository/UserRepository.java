package com.emirpetek.walletapp.walletApp.repository;

import com.emirpetek.walletapp.walletApp.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface UserRepository extends JpaRepository<User,Long> {


    @Query("SELECT u.password FROM User u WHERE u.id = :userID")
    String getHashPassword(@Param("userID") Long userID);


    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.password = :password WHERE u.id = :userID")
    int changePassword(@Param("userID") Long userID, @Param("password") String password);

    @Query("SELECT COUNT(*) FROM User u WHERE u.email = :email")
    Integer isEmailExist(@Param("email") String email);

    @Query("SELECT u.id FROM User u WHERE u.email = :email")
    Long getUserIdFromEmail(@Param("email") String email);

}
