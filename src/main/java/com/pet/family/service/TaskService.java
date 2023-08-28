package com.pet.family.service;

import com.pet.family.model.ItemTask;
import com.pet.family.model.Task;
import com.pet.family.model.User;
import com.pet.family.payload.request.TaskRequest;
import com.pet.family.repository.TaskRepository;
import com.pet.family.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tainy
 */
@Service
public class TaskService implements ITaskService {

    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(TaskRequest input) throws IOException {
        Task instance = new Task();
        instance = taskRepository.save(instance);

        instance.setTitle(input.getTitle());
        User user = userRepository.findById(input.getUserId()).orElse(null);
        instance.setUser(user);

        List<ItemTask> items = new ArrayList<>();
        for (int i = 0; i < input.getItems().size(); i++) {
            ItemTask item = input.getItems().get(i);
            item.setTask(instance);
            items.add(item);
        }

        instance.setItems(items);

        return taskRepository.save(instance);
    }

    @Override
    public Task update(Long id, TaskRequest input) {
        Task instance = taskRepository.findById(id).orElse(null);

        instance.setTitle(input.getTitle());
//        instance.setItems(input.getItems());

        User user = userRepository.findById(input.getUserId()).orElse(null);
        instance.setUser(user);

        return taskRepository.save(instance);
    }

    @Override
    public List<Task> tasksByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        return taskRepository.findTasksByUser(user);
    }
}
