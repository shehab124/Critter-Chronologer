package com.example.Critter_Chronologer.controller;

import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.DTO.PetDTO;
import com.example.Critter_Chronologer.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {

        Pet entity = PetDTO.petDTOToEntity(petDTO);
        PetDTO dto = petService.createPet(entity);
        return dto;
        //return petService.createPet(PetDTO.petDTOToEntity(petDTO));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        throw new UnsupportedOperationException();
    }

    @GetMapping
    public List<PetDTO> getPets(){
        throw new UnsupportedOperationException();
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        throw new UnsupportedOperationException();
    }
}
