package com.pet.family.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "treatments")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @Column(name = "nextdate")
    private Date nextDate;

    @Column(name = "createddate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
    }
}