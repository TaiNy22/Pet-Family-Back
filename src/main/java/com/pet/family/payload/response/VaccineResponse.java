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
public class VaccineResponse {
    private Long id;

    private String type;

    private boolean done;

    private Date date;

    private Date createdDate;

    private Pet pet;
}
