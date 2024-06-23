package com.example.Critter_Chronologer.controller;

import com.example.Critter_Chronologer.DTO.ScheduleDTO;
import com.example.Critter_Chronologer.entity.Employee;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.entity.Schedule;
import com.example.Critter_Chronologer.service.EmployeeService;
import com.example.Critter_Chronologer.service.PetService;
import com.example.Critter_Chronologer.service.ScheduleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    PetService petService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleService.createSchedule(scheduleDTOToEntity(scheduleDTO));
        return scheduleEntityToDTO(schedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        Iterable<Schedule> schedules = scheduleService.getAllSchedules();
        List<ScheduleDTO> dtos = new ArrayList<>();

        for(Schedule schedule : schedules)
        {
            dtos.add(scheduleEntityToDTO(schedule));
        }
        return dtos;
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        List<Schedule> schedules = scheduleService.getScheduleForPet(petId);
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();

        for(Schedule schedule : schedules)
        {
            scheduleDTOS.add(scheduleEntityToDTO(schedule));
        }
        return scheduleDTOS;
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        List<Schedule> schedules = scheduleService.getScheduleForEmployee(employeeId);
        List<ScheduleDTO> scheduleDTOS = new ArrayList<>();

        for(Schedule schedule : schedules)
        {
            scheduleDTOS.add(scheduleEntityToDTO(schedule));
        }
        return scheduleDTOS;
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        List<Schedule> schedules = scheduleService.getScheduleByCustomer(customerId);
        List<ScheduleDTO> dtos = new ArrayList<>();

        for(Schedule schedule : schedules)
        {
            dtos.add(scheduleEntityToDTO(schedule));
        }
        return dtos;
    }

    private ScheduleDTO scheduleEntityToDTO(Schedule schedule)
    {
        ScheduleDTO dto = new ScheduleDTO();

        // set pet ids
        List<Pet> pets = schedule.getPets();
        List<Long> petIds = new ArrayList<>();
        for (Pet pet : pets)
        {
            petIds.add(pet.getId());
        }
        dto.setPetIds(petIds);

        // Set employee ids
        List<Employee> employees = schedule.getEmployees();
        List<Long> employeeIds = new ArrayList<>();
        for (Employee employee : employees)
        {
            employeeIds.add(employee.getId());
        }
        dto.setEmployeeIds(employeeIds);

        // set rest of values
        BeanUtils.copyProperties(schedule, dto);
        return dto;
    }

    private Schedule scheduleDTOToEntity(ScheduleDTO dto)
    {
        Schedule schedule = new Schedule();

        List<Long> employeeIds = dto.getEmployeeIds();
        List<Employee> employees = new ArrayList<>();
        for(Long id : employeeIds)
        {
            employees.add(employeeService.findById(id).get());
        }
        schedule.setEmployees(employees);

        List<Long> petIds = dto.getPetIds();
        List<Pet> pets = new ArrayList<>();
        for(Long id : petIds)
        {
            pets.add(petService.findPetById(id).get());
        }
        schedule.setPets(pets);

        BeanUtils.copyProperties(dto, schedule);
        return schedule;
    }

}
