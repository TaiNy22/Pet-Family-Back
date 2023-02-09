package com.pet.family.repository;

import com.pet.family.model.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tainy
 */
public interface ReminderRepository extends JpaRepository<Reminder, Long> {
}
