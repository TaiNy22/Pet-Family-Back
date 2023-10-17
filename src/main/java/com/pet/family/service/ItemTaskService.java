package com.pet.family.service;

import com.pet.family.model.ItemTask;
import com.pet.family.model.Task;
import com.pet.family.repository.ItemTaskRepository;
import com.pet.family.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ItemTaskService implements IItemTaskService {

    private ItemTaskRepository itemTaskRepository;

    @Autowired
    private TaskRepository taskRepository;

    public ItemTaskService(ItemTaskRepository itemTaskRepository) {
        this.itemTaskRepository = itemTaskRepository;
    }

    @Override
    public ItemTask findById(Long id) {
        return itemTaskRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        itemTaskRepository.deleteById(id);
    }

    @Override
    public void deleteByTask(Task task) {
        List<ItemTask> itemTaskList = itemTaskRepository.findItemTasksByTask(task);

        itemTaskList.forEach(itemTask -> {
            deleteById(itemTask.getId());
        });
    }

    @Override
    public List<ItemTask> findAll() {
        return itemTaskRepository.findAll();
    }

    @Override
    public ItemTask save(ItemTask input) throws IOException {
        ItemTask instance = new ItemTask();
        instance.setDescription(input.getDescription());
        instance.setDone(input.getDone());

        instance.setTask(input.getTask());

        return itemTaskRepository.save(instance);
    }

    @Override
    public ItemTask update(Long id, ItemTask input) {
        ItemTask instance = itemTaskRepository.findById(id).orElse(null);
        instance.setDescription(input.getDescription());
        instance.setDone(input.getDone());
        instance.setTask(input.getTask());

        return itemTaskRepository.save(instance);
    }

    @Override
    public List<ItemTask> itemTasksByTaskId(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);

        return itemTaskRepository.findItemTasksByTask(task);
    }
}
