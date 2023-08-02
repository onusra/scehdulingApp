package com.myscedular.org.ombeninusra.service;

import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    @Autowired
    private AccountRepository accountReposity;

    public ResponseEntity<String> registration(UserAccount userAccount){
        accountReposity.save(userAccount);
        return ResponseEntity.ok(userAccount.getLastName() + " your account has been created");
    }

    public List<UserAccount> getAllUsers(){
        return accountReposity.findAll();
    }
}