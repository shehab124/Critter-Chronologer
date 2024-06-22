package com.example.Critter_Chronologer.repository;

import com.example.Critter_Chronologer.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.DayOfWeek;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByDaysAvailable(DayOfWeek date);
}
