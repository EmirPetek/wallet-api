package com.emirpetek.walletapp.walletApp.controller;

import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.dto.request.PasswordChangeRequest;
import com.emirpetek.walletapp.walletApp.model.PasswordResponse;
import com.emirpetek.walletapp.walletApp.model.User;
import com.emirpetek.walletapp.walletApp.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
@CrossOrigin("*/*")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


//    @PostMapping
//    public ResponseEntity<User> createUser(
//            @Validated
//            @RequestBody
//            User user){
//        return ResponseEntity.ok(userService.createUser(user));
//    }

    @GetMapping("/{userID}")
    public ResponseEntity<UserDTO> getUserByID(@PathVariable Long userID) {
        return ResponseEntity.ok(userService.getUserById(userID));
    }

    @GetMapping("/getFullName/{userID}")
    public ResponseEntity<String> getFirstLastNameFromUserID(@PathVariable Long userID) {
        return ResponseEntity.ok(userService.getFirstLastNameFromUserID(userID));
    }


    @PostMapping("/changePassword")
    public ResponseEntity<PasswordResponse> changePassword(@RequestBody PasswordChangeRequest passwordChangeRequest){
        return ResponseEntity.ok(userService.changePassword(passwordChangeRequest));
    }

    @GetMapping("/isEmailExist/{email}")
    public ResponseEntity<Boolean> isEmailExist(@PathVariable String email){
        return ResponseEntity.ok(userService.isEmailExist(email));
    }

    @GetMapping("getUserIdFromEmail/{email}")
    public ResponseEntity<Long> getUserIdFromEmail(@PathVariable String email){
        return ResponseEntity.ok(userService.getUserIdFromEmail(email));
    }


//    @GetMapping("/all")
//    public List<UserDTO> getAllUsers(){
//     return userService.getAllUser();
//    }

}
