package com.pet.family.payload.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class ReminderResponse {
    private Long id;

    private String description;

    private String title;

    private Date date;

    private Date createdDate;
}
