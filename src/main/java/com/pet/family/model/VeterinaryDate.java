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
@Table(name = "veterinary_dates")
public class VeterinaryDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "hour")
    private String hour;

    @Column(name = "place")
    private String place;

    @Column(name = "date")
    private Date date;

    @Column(name = "createddate", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
    }
}
