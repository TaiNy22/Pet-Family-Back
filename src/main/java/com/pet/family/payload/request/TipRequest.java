package com.pet.family.payload.request;

import com.pet.family.model.PetType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TipRequest {
    private String content;

    private MultipartFile image;

    private String title;

    private PetType type;
}
