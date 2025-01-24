package com.emirpetek.walletapp.walletApp;

import com.emirpetek.walletapp.walletApp.controller.UserController;
import com.emirpetek.walletapp.walletApp.dto.AccountDTO;
import com.emirpetek.walletapp.walletApp.dto.UserDTO;
import com.emirpetek.walletapp.walletApp.dto.converter.UserDtoConverter;
import com.emirpetek.walletapp.walletApp.dto.request.CreateCardRequest;
import com.emirpetek.walletapp.walletApp.exception.LoginException;
import com.emirpetek.walletapp.walletApp.model.Account;
import com.emirpetek.walletapp.walletApp.model.Card;
import com.emirpetek.walletapp.walletApp.model.User;
import com.emirpetek.walletapp.walletApp.repository.UserRepository;
import com.emirpetek.walletapp.walletApp.service.AccountService;
import com.emirpetek.walletapp.walletApp.service.CardService;
import com.emirpetek.walletapp.walletApp.service.LoginService;
import com.emirpetek.walletapp.walletApp.service.UserService;
import com.emirpetek.walletapp.walletApp.util.account.CreateAccountInformation;
import com.emirpetek.walletapp.walletApp.util.cardInformation.CreateCardInformation;
import com.emirpetek.walletapp.walletApp.util.cardInformation.GetCardInformation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
public class WalletAppApplication {

	public final UserRepository userRepository;
    public final UserService userService;
    public final LoginService loginService;
    public final CardService cardService;
    public final AccountService accountService;

    public WalletAppApplication(UserRepository userRepository, UserService userService, LoginService loginService, CardService cardService, AccountService accountService) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.loginService = loginService;
        this.cardService = cardService;
        this.accountService = accountService;
    }

    public static void main(String[] args) {

		SpringApplication.run(WalletAppApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(UserService userService) {


        return args -> {
            // UserService üzerinden kullanıcı oluştur
/*
            System.out.println("Size: " + userService.getUserSize().toString());

            for (UserDTO user : this.userService.getAllUser()) {
                System.out.println(user);
            }*/
            //(userService.getAllUser()).forEach(System.out::println);

//            accountService.createAccount(
//                    new Account(
//                        new CreateAccountInformation().generateAccountNumber(),
//                            new BigDecimal("100000.0"),
//                            "TRY",
//                            3,
//                            System.currentTimeMillis()
//                    )
//            );

            //(accountService.getAccountByUserID(1L)).forEach(System.out::println);


//            cardService.createValidCard(
//                    new Card(
//                           new GetCardInformation().getCardNumber(),
//                            "Emir Petek",
//                            new GetCardInformation().getExpireDate(),
//                            new GetCardInformation().getCvvNumber(),
//                            Card.CardType.VISA,
//                            1L,
//                            System.currentTimeMillis(),
//                            2
//                    )
//            );


//            cardService.createValidCard(new CreateCardRequest(
//                    Card.CardType.MASTERCARD,
//                    "Emir Petek",
//                    1L,
//                    new BigDecimal(113500),
//                    Card.CurrencyType.TRY
//            ));


            (cardService.getCardInfo(1L)).forEach(System.out::println);





//            cardService.createValidCard(
//                    new Card(
//                            new GetCardInformation().getCardNumber(),
//                            "Emir Petek",
//                            new GetCardInformation().getExpireDate(),
//                            new GetCardInformation().getCvvNumber(),
//                            Card.CardType.
//
//                    )
//            );


//            UserDTO userDTO = loginService.loginByEmailAndPassword("emirpetek2002@gmail.com","emir1234");
//            if (userDTO == null){
//                throw new LoginException("There is no user with this email.");
//            }else {
//                System.out.println("Login is successfully completed. UserID: " + userDTO.getId().toString());
//            }
            /*loginService.registerUser(
                    new User(
                    "Emir2",
                    "Deneme2",
                    "emirdeneme2@gmail.com",
                    "emir1234",
                    "16/11/1994",
                    System.currentTimeMillis()
            ));*/
        };
    }

}
