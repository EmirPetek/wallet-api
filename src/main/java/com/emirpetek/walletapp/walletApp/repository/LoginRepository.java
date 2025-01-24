package com.emirpetek.walletapp.walletApp.repository;


import com.emirpetek.walletapp.walletApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoginRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM user WHERE email = :email AND password = :password", nativeQuery = true)
    User loginByEmailAndPassword(@Param("email") String email, @Param("password") String password);

}
