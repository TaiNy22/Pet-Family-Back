package com.pet.family.payload.response;

import com.pet.family.model.Pet;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TreatmentResponse {
    private Long id;

    private Date date;

    private String description;

    private String title;

    private Date createdDate;

    private Pet pet;
}
