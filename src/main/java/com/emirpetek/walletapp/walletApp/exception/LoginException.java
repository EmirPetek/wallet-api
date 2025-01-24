package com.emirpetek.walletapp.walletApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoginException extends RuntimeException{
    public LoginException(String message){
        super(message);
    }

}
