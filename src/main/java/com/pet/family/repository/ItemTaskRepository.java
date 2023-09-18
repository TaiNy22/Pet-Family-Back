package com.pet.family.repository;

import com.pet.family.model.ItemTask;
import com.pet.family.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemTaskRepository extends JpaRepository<ItemTask, Long> {
    List<ItemTask> findItemTasksByTask(Task task);
}
