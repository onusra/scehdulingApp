package com.myscedular.org.ombeninusra.controllers;


import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {


    //Instantiating userAccount service class;
    @Autowired
    UserAccountService userAccountService;


    @PostMapping
    public ResponseEntity<String> userRegistration(@RequestBody UserAccount userAccount){

        return userAccountService.registration(userAccount);
    }

    @GetMapping("/getAllUsers")
    public List<UserAccount> getAllUser(){
        return userAccountService.getAllUsers();
    }
}
