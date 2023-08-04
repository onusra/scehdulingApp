package com.myscedular.org.ombeninusra.service;

import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class UserAccountServiceTest {


    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    @Autowired
    UserAccountService userAccountService;
    private  UserAccount userAccount;

    @Captor
    ArgumentCaptor<UserAccount> captor;
    @BeforeEach
    void setUp() {
        userAccount = UserAccount.
                builder().firstName("Ombeni").lastName("Nusra").
                age(12).email("onusra@angelo.edu").password("dhdshdghsdgs").
                scheduleList(List.of()).build();
    }

    @Test
    void registration() {
        //accountRepository.save(userAccount);

        userAccountService.registration(userAccount);
        verify(accountRepository).save(captor.capture());

        assertEquals(captor.getValue(), userAccount);
    }

    @Test
    void getUserById() {
         final int id = 1;

         Optional<UserAccount> user = accountRepository.findById(1);

         if(user.isPresent()){
             verify(accountRepository).findById(1);

             assertEquals(user.get(), userAccount);
         }



    }

    @Test
    void getAllUsers() {
        userAccountService.getAllUsers();

        verify(accountRepository).findAll();
    }
}