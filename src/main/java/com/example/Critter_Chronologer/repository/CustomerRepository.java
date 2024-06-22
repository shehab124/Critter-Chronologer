package com.example.Critter_Chronologer.repository;

import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findCustomerByPetsId(Long petId);
}
