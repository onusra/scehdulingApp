package com.myscedular.org.ombeninusra.repository;

import com.myscedular.org.ombeninusra.entities.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {


}
