package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TreatmentRequest {
    private String title;

    private String description;

    private Date date;

    private Date nextDate;

    private Long petId;

    private String reminder;
}
