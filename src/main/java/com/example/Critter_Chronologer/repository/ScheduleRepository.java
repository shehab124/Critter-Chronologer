package com.example.Critter_Chronologer.repository;

import com.example.Critter_Chronologer.entity.Employee;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.entity.Schedule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    List<Schedule> findSchedulesByPetsId(Long pet_id);

    List<Schedule> findSchedulesByEmployeesId(Long employee_id);

}
