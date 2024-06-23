package com.example.Critter_Chronologer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedule_pets",
            joinColumns = @JoinColumn(
                    name = "schedule_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "pet_id", referencedColumnName = "id"
            )
    )
    private List<Pet> pets;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "schedule_employees",
            joinColumns = @JoinColumn(
                    name = "schedule_id", referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "employee_id", referencedColumnName = "id"
            )
    )
    private List<Employee> employees;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<EmployeeSkill> activities;
}
