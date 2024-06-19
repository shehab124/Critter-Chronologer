package com.example.Critter_Chronologer.DTO;

import com.example.Critter_Chronologer.entity.EmployeeSkill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

/**
 * Represents a request to find available employees by skills. Does not map
 * to the database directly.
 */
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeRequestDTO {
    private Set<EmployeeSkill> skills;
    private LocalDate date;

}
