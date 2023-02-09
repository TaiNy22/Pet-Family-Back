package com.pet.family.service;

import com.pet.family.model.Reminder;
import com.pet.family.payload.request.ReminderRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface IReminderService {
    public Reminder findById(Long id);

    public void deleteById(Long id);

    public List<Reminder> findAll();

    public Reminder save(ReminderRequest input);

    public Reminder update(Long id, ReminderRequest input);
}
