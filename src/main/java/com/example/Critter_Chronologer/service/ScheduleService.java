package com.example.Critter_Chronologer.service;

import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.entity.Schedule;
import com.example.Critter_Chronologer.repository.CustomerRepository;
import com.example.Critter_Chronologer.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Iterable<Schedule> getAllSchedules()
    {
        return scheduleRepository.findAll();
    }

    public Schedule createSchedule(Schedule schedule)
    {
        return scheduleRepository.save(schedule);
    }

    public List<Schedule> getScheduleForPet(Long petId)
    {
        return scheduleRepository.findSchedulesByPetsId(petId);
    }

    public List<Schedule> getScheduleForEmployee(Long employeeId)
    {
        return scheduleRepository.findSchedulesByEmployeesId(employeeId);
    }

    public List<Schedule> getScheduleByCustomer(Long customerId)
    {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);

        if(optionalCustomer.isPresent())
        {
            Customer customer = optionalCustomer.get();
            List<Pet> pets = customer.getPets();
            List<Schedule> schedules = new ArrayList<>();

            for(Pet pet: pets)
            {
                schedules.addAll(scheduleRepository.findSchedulesByPetsId(pet.getId()));
            }
            return schedules;
        }
        return null;
    }

}
