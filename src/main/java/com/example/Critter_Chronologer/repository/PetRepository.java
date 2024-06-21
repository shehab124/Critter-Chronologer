package com.example.Critter_Chronologer.repository;

import com.example.Critter_Chronologer.entity.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findPetsByCustomerId(Long owner_id);
}
