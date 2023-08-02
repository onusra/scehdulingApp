package com.myscedular.org.ombeninusra.service;

import com.myscedular.org.ombeninusra.entities.Schedule;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepo scheduleRepo;

    //Instantiating Account service
    @Autowired
    UserAccountService getUserAccountService;
    public ResponseEntity<String> createScedule (int id, Schedule schedule){
        //scheduleRepo.save(schedule);
        //Retrieve the user with the given id from the path
        UserAccount userAccount = getUserAccountService.getUserById(id);

        //Add the schedule into the user schedule list
        userAccount.getScheduleList().add(schedule);

        //Update the user with the list containing the schedule.
        getUserAccountService.registration(userAccount);

        return ResponseEntity.ok(schedule.getTaskName() + " has been created");
    }
}
