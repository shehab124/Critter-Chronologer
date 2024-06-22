package com.example.Critter_Chronologer.controller;

import com.example.Critter_Chronologer.DTO.CustomerDTO;
import com.example.Critter_Chronologer.DTO.EmployeeDTO;
import com.example.Critter_Chronologer.DTO.EmployeeRequestDTO;
import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.entity.Employee;
import com.example.Critter_Chronologer.entity.EmployeeSkill;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.service.CustomerService;
import com.example.Critter_Chronologer.service.EmployeeService;
import com.example.Critter_Chronologer.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Handles web requests related to Users.
 *
 * Includes requests for both customers and employees. Splitting this into separate user and customer controllers
 * would be fine too, though that is not part of the required scope for this class.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    CustomerService customerService;

    @Autowired
    PetService petService;

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/customer")
    public CustomerDTO saveCustomer(@RequestBody CustomerDTO customerDTO){

        return customerEntityToDTO(
                customerService.createCustomer(
                        customerDTOToEntity(customerDTO)
                )
        );
    }

    @GetMapping("/customer")
    public List<CustomerDTO> getAllCustomers(){
        Iterable<Customer> customers = customerService.findAllCustomers();
        List<CustomerDTO> customerDTOS = new ArrayList<>();

        if(customers != null)
        {
            for (Customer customer : customers)
            {
                customerDTOS.add(customerEntityToDTO(customer));
            }
            return customerDTOS;
        }

        else return null;
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId)
    {
        Optional<Pet> pet = petService.findPetById(petId);
        if(pet.isPresent())
        {
            Customer customer = pet.get().getCustomer();
            if(customer != null)
                return customerEntityToDTO(customer);
        }
        return null;
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeEntityToDTO(employeeService.createEmployee(employeeDTOToEntity(employeeDTO)));
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        Optional<Employee> optional = employeeService.findById(employeeId);
        Employee employee;
        return optional.map(this::employeeEntityToDTO).orElse(null);
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        employeeService.setAvailability(daysAvailable, employeeId);
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        List<EmployeeDTO> result = new ArrayList<>();
        List<Employee> employees = employeeService.findEmployeesForService(employeeDTO);
        for(Employee employee : employees)
        {
            result.add(employeeEntityToDTO(employee));
        }
        return result;
    }


    public Customer customerDTOToEntity(CustomerDTO dto)
    {
        Customer customer = new Customer();

        List<Pet> pets = new ArrayList<>();

        if(dto.getPetIds() != null)
        {
            List<Long> ids = dto.getPetIds();

            for(int i = 0; i < ids.size(); i++)
            {
                Optional<Pet> pet = petService.findPetById(ids.get(i));
                if(pet.isPresent())
                    pets.add(pet.get());
            }
            customer.setPets(pets);
        }

        BeanUtils.copyProperties(dto, customer);
        return customer;
    }

    public CustomerDTO customerEntityToDTO(Customer customer)
    {
        CustomerDTO dto = new CustomerDTO();

        if(customer.getPets() != null)
        {
            List<Pet> pets = customer.getPets();
            List<Long> ids = new ArrayList<>();

            for(Pet pet : pets)
            {
                ids.add(pet.getId());
            }
            dto.setPetIds(ids);
        }

        BeanUtils.copyProperties(customer, dto);
        return dto;
    }


    public EmployeeDTO employeeEntityToDTO(Employee employee)
    {
        EmployeeDTO dto = new EmployeeDTO();
//        Set<DayOfWeek> days = employee.getDaysAvailable();
//        Set<EmployeeSkill> skills = employee.getSkills();
//        dto.setDaysAvailable(days);
//        dto.setSkills(skills);
        BeanUtils.copyProperties(employee, dto);
        return dto;
    }

    public Employee employeeDTOToEntity(EmployeeDTO dto)
    {
        Employee employee = new Employee();
        BeanUtils.copyProperties(dto, employee);
        return employee;
    }

}
