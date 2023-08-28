package com.pet.family.repository;

import com.pet.family.model.Task;
import com.pet.family.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tainy
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByUser(User user);
}
