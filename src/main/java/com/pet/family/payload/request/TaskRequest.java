package com.pet.family.payload.request;

import com.pet.family.model.ItemTask;
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

    private List<ItemTask> items;

    private Long userId;
}
