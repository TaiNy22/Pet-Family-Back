package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class VaccineRequest {
    private String type;

    private boolean done;

    private Date date;

    private Long petId;
}
