package com.pet.family.payload.response;

import com.pet.family.model.PetType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class PetResponse {
    private Long id;

    private Long age;

    private String ageType;

    private String avatar;

    private String gender;

    private String name;

    private Boolean sterilization;

    private PetType type;

    private String weight;

    private Date createdDate;
}
