package com.pet.family.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Tainy
 */
@Getter
@Setter
@Entity
@Table(name = "reminders")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "weight")
    private String weight;

    @Column(name = "type")
    private PetType type;

    @Column(name = "sterilization")
    private Boolean sterilization;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "createddate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
    }
}
