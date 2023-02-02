package com.pet.family.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Tainy
 */
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private UserRol name;
}
