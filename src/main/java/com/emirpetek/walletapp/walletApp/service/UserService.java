package com.emirpetek.walletapp.walletApp.service;

import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.UserDtoConverter;
import com.emirpetek.walletapp.walletApp.dto.request.PasswordChangeRequest;
import com.emirpetek.walletapp.walletApp.exception.UserNotFoundException;
import com.emirpetek.walletapp.walletApp.model.PasswordResponse;
import com.emirpetek.walletapp.walletApp.model.User;
import com.emirpetek.walletapp.walletApp.repository.UserRepository;
import com.emirpetek.walletapp.walletApp.util.hashPassword.HashPassword;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }


    public User createUser(User user){
        return userRepository.save(user);
    }

    public UserDTO getUserById(Long userID){
        return userDtoConverter.convertUserDto(
                userRepository.findById(userID)
                        .orElseThrow(() -> new UserNotFoundException("User not found."))
        );
        //return userDtoConverter.convertUserDto(userRepository.getReferenceById(userID));
    }

    public String getFirstLastNameFromUserID(Long userID){
        User user = userRepository.findById(userID).orElseThrow(() -> new UserNotFoundException("User not found."));
        return user.getFirstName() + " " + user.getLastName();
    }

    public List<UserDTO> getAllUser(){
        return userRepository.findAll()
                .stream()
                .map(userDtoConverter::convertUserDto)
                .collect(Collectors.toList());
    }

    public Boolean isUserValidByUserId(Long id){ return userRepository.existsById(id); }

    public Long getUserSize(){
        return userRepository.count();
    }

    public PasswordResponse changePassword(PasswordChangeRequest passwordChangeRequest){
        if (!isUserValidByUserId(passwordChangeRequest.getUserID())){
            return PasswordResponse.USER_NOT_FOUND;
        }

        if (passwordChangeRequest.getOldPassword() != null && verifyPassword(passwordChangeRequest.getOldPassword(),passwordChangeRequest.getUserID())){
            return PasswordResponse.OLD_PASSWORD_INCORRECT;
        }

        int changePassword = userRepository.changePassword(passwordChangeRequest.getUserID(),new HashPassword().hashWithSHA256(passwordChangeRequest.getNewPassword()));
        if (changePassword > 0) return PasswordResponse.SUCCESSFUL;
        else return PasswordResponse.SERVER_ERROR;

    }



    public Boolean verifyPassword(String password, Long userID){
        try{
            return userRepository.getHashPassword(userID) == new HashPassword().hashWithSHA256(password);
        }catch (Exception e){
            return false;
        }
    }


    public Boolean isEmailExist(String email){
        try {
            return userRepository.isEmailExist(email) > 0;
        }catch (Exception e){
            return false;
        }
    }


    public Long getUserIdFromEmail(String email){
        try {
            return userRepository.getUserIdFromEmail(email);
        }catch (Exception e){
            return -1L;
        }
    }







}
