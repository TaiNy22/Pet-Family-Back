package com.pet.family.payload.request;

import com.pet.family.model.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemTaskRequest {
    private Long id;

    private Boolean done;

    private String description;

    private Task task;
}
