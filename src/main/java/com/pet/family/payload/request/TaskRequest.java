package com.pet.family.payload.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Tainy
 */
@Getter
@Setter
public class TaskRequest {
    private String title;

    private List<ItemTaskRequest> items;

    private Long userId;
}
