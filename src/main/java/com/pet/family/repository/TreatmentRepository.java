package com.pet.family.repository;

import com.pet.family.model.Pet;
import com.pet.family.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Tainy
 */
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
    Optional<Treatment> findById(Long id);

    List<Treatment> findTreatmentsByPet(Pet pet);
}
