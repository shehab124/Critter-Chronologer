package com.example.Critter_Chronologer.service;

import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer createCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerById(Long id)
    {
        return customerRepository.findById(id);
    }

}
