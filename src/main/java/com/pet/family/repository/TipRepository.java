package com.pet.family.repository;

import com.pet.family.model.Tip;
import com.pet.family.model.TipType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tainy
 */
public interface TipRepository extends JpaRepository<Tip, Long> {
    List<Tip> findTipByType(TipType type);
}