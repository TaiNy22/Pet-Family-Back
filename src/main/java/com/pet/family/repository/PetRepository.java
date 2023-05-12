package com.pet.family.repository;

import com.pet.family.model.Pet;
import com.pet.family.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tainy
 */
public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findPetByUser(User user);
}
