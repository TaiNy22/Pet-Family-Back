package com.pet.family.repository;

import com.pet.family.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tainy
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
}
