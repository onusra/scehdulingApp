package com.myscedular.org.ombeninusra.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logs {

    Logger logger = LoggerFactory.getLogger(Logs.class);
    @Before("execution(* com.myscedular.org.ombeninusra.service.UserAccountService.registration(..))")
    public void registerLoger(JoinPoint j){
        logger.info(" You have registered a user with the following info : " + j.getArgs()[0]);
    }

    @Before("execution(* com.myscedular.org.ombeninusra.service.ScheduleService.createScedule(..))")
    public void createScheduleLoger(JoinPoint j){
        logger.info(" You have created a schedule with the following info : id : " +
                j.getArgs()[0] + " . schedule: " + j.getArgs()[1]);
    }

    @Before("execution(* com.myscedular.org.ombeninusra.service.ScheduleService.deleteScheduleById(..))")
    public void deleteScheduleLoger(JoinPoint j){
        logger.info(" You have deleted a schedule with the following name : " + j.getArgs()[1]);
    }
}
