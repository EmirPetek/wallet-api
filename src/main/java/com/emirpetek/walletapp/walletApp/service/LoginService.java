package com.emirpetek.walletapp.walletApp.service;


import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.UserDtoConverter;
import com.emirpetek.walletapp.walletApp.model.User;
import com.emirpetek.walletapp.walletApp.repository.LoginRepository;
import com.emirpetek.walletapp.walletApp.repository.UserRepository;
import com.emirpetek.walletapp.walletApp.util.hashPassword.HashPassword;
import org.springframework.stereotype.Service;

@Service
public class LoginService {


    private final LoginRepository loginRepository;
    private final UserDtoConverter userDtoConverter;


    public LoginService(LoginRepository loginRepository, UserDtoConverter userDtoConverter) {
        this.loginRepository = loginRepository;
        this.userDtoConverter = userDtoConverter;
    }

    public UserDTO loginByEmailAndPassword(String email, String password){
        return userDtoConverter.convertUserDto(loginRepository.loginByEmailAndPassword(email, new HashPassword().hashWithSHA256(password)));
    }

    public Boolean isUserSaved(String email){
        return loginRepository.existsByEmail(email);
    }

    public Boolean registerUser(User user){
        if (isUserSaved(user.getEmail())){
            return false;
        }else {
            user.setPassword(new HashPassword().hashWithSHA256(user.password));
            loginRepository.save(user);
            return true;
        }
    }

}
