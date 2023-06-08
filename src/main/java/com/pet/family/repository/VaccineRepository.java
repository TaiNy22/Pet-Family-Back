package com.pet.family.repository;

import com.pet.family.model.Pet;
import com.pet.family.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Tainy
 */
@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
    Optional<Vaccine> findById(Long id);

    List<Vaccine> findVaccinesByPet(Pet pet);
}