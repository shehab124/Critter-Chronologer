package com.example.Critter_Chronologer.controller;

import com.example.Critter_Chronologer.DTO.CustomerDTO;
import com.example.Critter_Chronologer.DTO.EmployeeDTO;
import com.example.Critter_Chronologer.DTO.EmployeeRequestDTO;
import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.service.CustomerService;
import com.example.Critter_Chronologer.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        throw new UnsupportedOperationException();
    }

    @GetMapping("/customer/pet/{petId}")
    public CustomerDTO getOwnerByPet(@PathVariable long petId){
        throw new UnsupportedOperationException();
    }

    @PostMapping("/employee")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        throw new UnsupportedOperationException();
    }

    @PostMapping("/employee/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @PutMapping("/employee/{employeeId}")
    public void setAvailability(@RequestBody Set<DayOfWeek> daysAvailable, @PathVariable long employeeId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/employee/availability")
    public List<EmployeeDTO> findEmployeesForService(@RequestBody EmployeeRequestDTO employeeDTO) {
        throw new UnsupportedOperationException();
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

}
