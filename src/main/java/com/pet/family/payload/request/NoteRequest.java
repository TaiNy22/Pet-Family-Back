package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Tainy
 */
@Getter
@Setter
public class NoteRequest {
    private String title;

    private String description;

    private Long userId;
}
