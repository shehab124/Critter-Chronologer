package com.example.Critter_Chronologer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private PetType type;
    private LocalDate birthDate;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Customer customer;

}
