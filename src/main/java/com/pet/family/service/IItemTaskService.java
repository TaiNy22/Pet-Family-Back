package com.pet.family.service;

import com.pet.family.model.ItemTask;
import com.pet.family.model.Task;

import java.io.IOException;
import java.util.List;

public interface IItemTaskService {
    public ItemTask findById(Long id);

    public void deleteById(Long id);

    public void deleteByTask(Task task);

    public List<ItemTask> findAll();

    public ItemTask save(ItemTask input) throws IOException;

    public ItemTask update(Long id, ItemTask input);

    public List<ItemTask> itemTasksByTaskId(Long taskId);
}
