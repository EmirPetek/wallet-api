package com.emirpetek.walletapp.walletApp.dto.converter;

import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public UserDTO convertUserDto(User u){

        if (u == null) {
            return null; // Güvenlik için null kontrolü
        }

        return new
                UserDTO(
                u.getId(),
                u.getFirstName(),
                u.getLastName(),
                u.getEmail(),
                u.getBirthdate(),
                u.getCreatedAt()
        );
    }


}
