package com.myscedular.org.ombeninusra.service;

import com.myscedular.org.ombeninusra.dao.Login;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountService {

    //Instantiating account Repo
    @Autowired
    private AccountRepository accountReposity;



    public ResponseEntity<String> registration(UserAccount userAccount){
        accountReposity.save(userAccount);
        return ResponseEntity.ok(userAccount.getFirstName() + " " + userAccount.getLastName() + " your account has been created");
    }

    public UserAccount getUserById(int id){
        return accountReposity.findById(id).get();
    }

    public List<UserAccount> getAllUsers(){
        return accountReposity.findAll();
    }

    public ResponseEntity<String> login(Login login){
        return ResponseEntity.ok("You have logged in with the following inf : " + login);
    }
}
