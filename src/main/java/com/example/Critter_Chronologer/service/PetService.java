package com.example.Critter_Chronologer.service;

import com.example.Critter_Chronologer.DTO.PetDTO;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public PetDTO createPet(Pet pet)
    {
        return PetDTO.petEntityToDTO(petRepository.save(pet));
    }
}
