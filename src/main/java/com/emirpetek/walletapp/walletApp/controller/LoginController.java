package com.emirpetek.walletapp.walletApp.controller;

import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.dto.request.LoginRequest;
import com.emirpetek.walletapp.walletApp.dto.request.RegisterRequest;
import com.emirpetek.walletapp.walletApp.model.User;
import com.emirpetek.walletapp.walletApp.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/v1/auth")
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginWithEmailAndPassword(@RequestBody LoginRequest loginRequest) {
        Optional<UserDTO> user = Optional.ofNullable(
                loginService.loginByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword()));
        return user.map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody RegisterRequest registerRequest){
        return ResponseEntity.ok(loginService.registerUser(registerRequest.getUser()));
    }
}
