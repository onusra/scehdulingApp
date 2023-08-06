package com.myscedular.org.ombeninusra.controllers;


import com.myscedular.org.ombeninusra.dao.Login;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin

//This annotations means this is a rest controller
@RestController
public class Controller {


    //Instantiating userAccount service class;
    @Autowired
    UserAccountService userAccountService;


    //This registers a user and save them in the database
    @PostMapping
    public ResponseEntity<String> userRegistration(@RequestBody UserAccount userAccount){

        return userAccountService.registration(userAccount);
    }


    //This returns all users
    @GetMapping("/getAllUsers")
    public List<UserAccount> getAllUser(){
        return userAccountService.getAllUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){
        return userAccountService.login(login);
    }

}
