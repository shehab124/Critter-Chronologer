package com.example.Critter_Chronologer.DTO;

import com.example.Critter_Chronologer.entity.Pet;
import com.example.Critter_Chronologer.entity.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

/**
 * Represents the form that pet request and response data takes. Does not map
 * to the database directly.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PetDTO {
    private long id;
    private PetType type;
    private String name;
    private long ownerId;
    private LocalDate birthDate;
    private String notes;

    public static Pet petDTOToEntity(PetDTO dto)
    {
        Pet pet = new Pet();
        BeanUtils.copyProperties(dto, pet);
        return pet;
    }

    public static PetDTO petEntityToDTO(Pet pet)
    {
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(pet, dto);
        return dto;
    }

}
