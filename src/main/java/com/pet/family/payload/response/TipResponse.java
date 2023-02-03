package com.pet.family.payload.response;

import com.pet.family.model.TipType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TipResponse {
    private Long id;

    private String content;

    private String title;

    private String type;

    private Date createdDate;
}
