package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class ReminderRequest {
    private String description;

    private String title;

    private Date date;
}
