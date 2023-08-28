package com.pet.family.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Tainy
 */
@Getter
@Setter
@Entity
@Table(name = "item_tasks")
public class ItemTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean done;

    private String description;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
