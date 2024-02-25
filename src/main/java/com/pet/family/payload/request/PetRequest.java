package com.pet.family.payload.request;

import com.pet.family.model.PetType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Tainy
 */
@Getter
@Setter
public class PetRequest {
    private Long age;

    private String ageType;

    private String avatar;

    private String gender;

    private String name;

    private Boolean sterilization;

    private PetType type;

    private Long userId;

    private String weight;
}
