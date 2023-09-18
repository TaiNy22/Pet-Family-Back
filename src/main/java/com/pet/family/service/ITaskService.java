package com.pet.family.service;

import com.pet.family.model.Task;
import com.pet.family.payload.request.TaskRequest;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
public interface ITaskService {
    public Task findById(Long id);

    public void deleteById(Long id);

    public List<Task> findAll();

    public Task save(TaskRequest input) throws IOException;

    public Task update(Long id, TaskRequest input) throws IOException;

    public List<Task> tasksByUserId(Long userId);
}
