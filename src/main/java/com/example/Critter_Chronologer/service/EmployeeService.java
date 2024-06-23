package com.example.Critter_Chronologer.service;

import com.example.Critter_Chronologer.DTO.EmployeeRequestDTO;
import com.example.Critter_Chronologer.entity.Employee;
import com.example.Critter_Chronologer.entity.EmployeeSkill;
import com.example.Critter_Chronologer.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findById(Long id)
    {
        return employeeRepository.findById(id);
    }

    public void setAvailability(Set<DayOfWeek> days, Long id)
    {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent())
        {
            Employee employee = optional.get();
            employee.setDaysAvailable(days);
            employeeRepository.save(employee);
        }
    }

    public List<Employee> findEmployeesForService(EmployeeRequestDTO employeeDTO)
    {
        List<Employee> employees = employeeRepository.findByDaysAvailable(employeeDTO.getDate().getDayOfWeek());
        List<Employee> result = new ArrayList<>();

        Set<EmployeeSkill> skillsNeeded = employeeDTO.getSkills();

        for(Employee employee : employees)
        {
           Set<EmployeeSkill> skills = employee.getSkills();
           if(skills.containsAll(skillsNeeded))
           {
               result.add(employee);
           }
        }
        return result;
    }
}
