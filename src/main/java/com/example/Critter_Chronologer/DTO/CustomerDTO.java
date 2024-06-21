package com.example.Critter_Chronologer.DTO;

import com.example.Critter_Chronologer.entity.Customer;
import com.example.Critter_Chronologer.service.PetService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Represents the form that customer request and response data takes. Does not map
 * to the database directly.
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CustomerDTO {
    private long id;
    private String name;
    private String phoneNumber;
    private String notes;
    private List<Long> petIds;


}
