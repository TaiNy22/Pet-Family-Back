package com.pet.family.repository;

import com.pet.family.model.VeterinaryDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Tainy
 */
@Repository
public interface VeterinaryDateRepository extends JpaRepository<VeterinaryDate, Long> {
    Optional<VeterinaryDate> findById(Long id);
}
