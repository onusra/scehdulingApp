package com.myscedular.org.ombeninusra.controllers;

import com.myscedular.org.ombeninusra.entities.Schedule;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.ScheduleRepo;
import com.myscedular.org.ombeninusra.service.ScheduleService;
import com.myscedular.org.ombeninusra.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {



     @Autowired
    ScheduleService scheduleService;

     //Implementing post mapping
    @PostMapping("/createTask/{id}")
    private ResponseEntity<String> createTask(@PathVariable("id") int id, @RequestBody Schedule schedule){
        return  scheduleService.createScedule(id,schedule);
    }


    //Implementing Get mapping
    @GetMapping("/get-schedules/{id}")
    public List<Schedule> getSchedules(@PathVariable("id") int id){
        return scheduleService.getAllSchedules(id);
    }


    //Implementing delete mapping
    @DeleteMapping("/delete-schedule/{id}/{schedule-name}")
    public ResponseEntity<String> deleteScheduleById
            (@PathVariable("id") int id, @PathVariable("schedule-name") String scheduleName){
        return scheduleService.deleteScheduleById(id,scheduleName);
    }


    //The put methods is used for updating a schedule.
    @PutMapping("/update/{id}/{name}")
    public ResponseEntity<String> scheduleUpdate
            (@PathVariable("id") int id, @RequestBody Schedule schedule, @PathVariable("name") String name){
        return scheduleService.updateSchedule(id,schedule,name);
    }

}
