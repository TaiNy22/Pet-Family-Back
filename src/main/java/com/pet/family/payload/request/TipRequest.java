package com.pet.family.payload.request;

import com.pet.family.model.PetType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TipRequest {
    private String content;

    private String title;

    private PetType type;
}
