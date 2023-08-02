package com.myscedular.org.ombeninusra.controllers;

import com.myscedular.org.ombeninusra.entities.Schedule;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.ScheduleRepo;
import com.myscedular.org.ombeninusra.service.ScheduleService;
import com.myscedular.org.ombeninusra.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScheduleController {



     @Autowired
    ScheduleService scheduleService;
    @PostMapping("/createTask/{id}")
    private ResponseEntity<String> createTask(@PathVariable("id") int id, @RequestBody Schedule schedule){
        return  scheduleService.createScedule(id,schedule);
    }

}
