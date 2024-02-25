package com.pet.family.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Tainy
 */
@Getter
@Setter
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "ageType")
    private String ageType;

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

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Treatment> treatments;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VeterinaryDate> veterinaryDates;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaccine> vaccines;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @PrePersist
    void onPrePersist() {
        this.createdDate = new Date();
    }
}
