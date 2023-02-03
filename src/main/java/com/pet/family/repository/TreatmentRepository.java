package com.pet.family.repository;

import com.pet.family.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Tainy
 */
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Long> {
}
