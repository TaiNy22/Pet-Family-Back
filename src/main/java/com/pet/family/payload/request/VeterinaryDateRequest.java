package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class VeterinaryDateRequest {
    private String description;

    private String hour;

    private String place;

    private Date date;
}
