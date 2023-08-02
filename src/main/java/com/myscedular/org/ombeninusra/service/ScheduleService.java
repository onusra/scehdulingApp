package com.myscedular.org.ombeninusra.service;

import com.myscedular.org.ombeninusra.entities.Schedule;
import com.myscedular.org.ombeninusra.entities.UserAccount;
import com.myscedular.org.ombeninusra.repository.ScheduleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {
    @Autowired
    ScheduleRepo scheduleRepo;


    Logger logger = LoggerFactory.getLogger(ScheduleService.class);
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

        return ResponseEntity.ok(schedule.getTaskName() + " task has been created");
    }


    //To return a list off all user schedules;
    public List<Schedule> getAllSchedules(int id){
        return getUserAccountService.getUserById(id).getScheduleList();

    }

    //Implementing schedule deletion
    public ResponseEntity<String> deleteScheduleById(int id, String schedule){
        logger.info(" ====> The value passed is : " + schedule);
        //scheduleRepo.deleteByTaskName(schedule);
        //Search a user with the given id
       UserAccount userAccount = getUserAccountService.
                getUserById(id);

        //Using stream to filter the user having a given schedule name
        List<Schedule> task =
                userAccount.getScheduleList().stream().filter(sc -> !(schedule.
                        equals(sc.getTaskName()))).toList();

        userAccount.getScheduleList().clear();
        userAccount.getScheduleList().addAll(task);

        //Updating schedule list with the new one
        getUserAccountService.registration(userAccount);
        //Returning to let the user know deletion was successful;
       return ResponseEntity.ok(schedule + " task has been deleted");
    }

    public ResponseEntity<String> updateSchedule(int id, Schedule schedule, String name){
        UserAccount userAccount = getUserAccountService.
                getUserById(id);

        //Using stream to filter the user having a given schedule name
        Schedule schedule1 =
                (Schedule) userAccount.getScheduleList().stream().filter(sc -> (name.
                        equals(sc.getTaskName())));
        userAccount.getScheduleList().remove(schedule1);
        userAccount.getScheduleList().add(schedule);

        return ResponseEntity.ok(schedule1.
                getTaskName() + " has been updated to " + schedule.getTaskName());

    }
}
