package com.myscedular.org.ombeninusra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @SequenceGenerator(name = "sequence",sequenceName = "sequence", allocationSize = 1)
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @Id
    int id;
    String taskName;
    String taskDescription;
    private java.sql.Time start;
    @Column(name = "local_time", columnDefinition = "TIME")
    private LocalTime localTime;

   @Column(name = "end_time", columnDefinition = "TIME")
   private LocalTime endTime;

    //private java.sql.Time end;

}
