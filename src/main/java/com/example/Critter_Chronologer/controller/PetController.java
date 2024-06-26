package com.example.Critter_Chronologer.controller;

import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.DTO.PetDTO;
import com.example.Critter_Chronologer.service.CustomerService;
import com.example.Critter_Chronologer.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Handles web requests related to Pets.
 */
@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    PetService petService;

    @Autowired
    CustomerService customerService;

    @PostMapping
    public PetDTO savePet(@RequestBody PetDTO petDTO) {
        return petEntityToDTO(petService.createPet(petDTOToEntity(petDTO)));
    }

    @GetMapping("/{petId}")
    public PetDTO getPet(@PathVariable long petId) {
        Optional<Pet> pet = petService.findPetById(petId);

        return pet.map(this::petEntityToDTO).orElse(null);
    }

    @GetMapping
    public List<PetDTO> getPets(){
        Iterable<Pet> pets = petService.getPets();
        List<PetDTO> petDTOS  = new ArrayList<>();
        for(Pet pet : pets)
        {
            petDTOS.add(petEntityToDTO(pet));
        }
        return petDTOS;
    }

    @GetMapping("/owner/{ownerId}")
    public List<PetDTO> getPetsByOwner(@PathVariable long ownerId) {
        List<Pet> pets = petService.getPetListByOwnerId(ownerId);
        List<PetDTO> petDTOS = new ArrayList<>();
        if(pets != null)
        {
            for (Pet pet : pets)
            {
                petDTOS.add(petEntityToDTO(pet));
            }
            return petDTOS;
        }
        return null;
    }

    public Pet petDTOToEntity(PetDTO dto)
    {
        Pet pet = new Pet();

        Optional<Customer> customerOptional = customerService.findCustomerById(dto.getOwnerId());

        customerOptional.ifPresent(pet::setCustomer);

        BeanUtils.copyProperties(dto, pet);
        return pet;
    }

    public PetDTO petEntityToDTO(Pet pet)
    {
        PetDTO dto = new PetDTO();

        dto.setOwnerId(pet.getCustomer().getId());

        BeanUtils.copyProperties(pet, dto);
        return dto;
    }

}
