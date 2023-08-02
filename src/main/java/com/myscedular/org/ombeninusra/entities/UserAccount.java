package com.myscedular.org.ombeninusra.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccount {

    @SequenceGenerator(name = "sequence", sequenceName = "sequence", allocationSize = 1)
    @GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
    @Id
    int id;

    @OneToMany(targetEntity = Schedule.class, cascade = CascadeType.ALL)
    @JoinColumn(name ="schedule", referencedColumnName = "id")
    private List<Schedule> scheduleList;

    @Column(name ="fname",nullable = false)
    String firstName;

    @Column(name = "lname",nullable = false)
    String lastName;

    @Column(name = "email",nullable = false, unique = true)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @Column( name = "age",nullable = false)
    int age;
}
