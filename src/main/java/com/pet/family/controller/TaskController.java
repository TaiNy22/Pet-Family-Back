package com.pet.family.controller;

import com.pet.family.model.Task;
import com.pet.family.payload.request.TaskRequest;
import com.pet.family.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/{taskId}")
    public Task getById(@PathVariable("taskId") Long taskId) {
        return taskService.findById(taskId);
    }

    @DeleteMapping(value = "/{taskId}")
    public void removeById(@PathVariable("taskId") Long taskId) {
        taskService.deleteById(taskId);
    }

    @GetMapping
    public List<Task> list() {
        return taskService.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<Task> getByUserId(@PathVariable("userId") Long userId) {
        return taskService.tasksByUserId(userId);
    }

    @PostMapping
    public Task create(@RequestBody TaskRequest input) throws IOException {
        return taskService.save(input);
    }

    @PutMapping(value = "/{taskId}")
    public Task update(@PathVariable("taskId") Long taskId, @RequestBody TaskRequest input) throws IOException {
        return taskService.update(taskId, input);
    }
}
