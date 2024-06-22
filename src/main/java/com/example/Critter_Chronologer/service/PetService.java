package com.example.Critter_Chronologer.service;

import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetService {

    @Autowired
    PetRepository petRepository;

    public Pet createPet(Pet pet)
    {
        return petRepository.save(pet);
    }

    public Optional<Pet> findPetById(Long id)
    {
        return petRepository.findById(id);
    }

    public Iterable<Pet> getPets()
    {
        return petRepository.findAll();
    }

    public List<Pet> getPetListByOwnerId(Long ownerId)
    {
        return petRepository.findPetsByCustomerId(ownerId);
    }

    public void deletePet(Long petId)
    {
         petRepository.deleteById(petId);
    }

}
