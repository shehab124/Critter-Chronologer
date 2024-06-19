package com.example.Critter_Chronologer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.DayOfWeek;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<EmployeeSkill> skills;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<DayOfWeek> daysAvailable;
}
