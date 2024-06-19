package com.example.Critter_Chronologer.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String notes;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Pet> petList;

}
