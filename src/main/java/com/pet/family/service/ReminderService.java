package com.pet.family.service;

import com.pet.family.model.Reminder;
import com.pet.family.payload.request.ReminderRequest;
import com.pet.family.repository.ReminderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tainy
 */
@Service
public class ReminderService implements IReminderService {
    private ReminderRepository reminderRepository;

    public ReminderService(ReminderRepository reminderRepository) {
        this.reminderRepository = reminderRepository;
    }

    @Override
    public Reminder findById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        reminderRepository.deleteById(id);
    }

    @Override
    public List<Reminder> findAll() {
        return reminderRepository.findAll();
    }

    @Override
    public Reminder save(ReminderRequest input) {
        Reminder instance = new Reminder();
        instance.setDescription(input.getDescription());
        instance.setTitle(input.getTitle());
        instance.setDate(input.getDate());

        return reminderRepository.save(instance);
    }

    @Override
    public Reminder update(Long id, ReminderRequest input) {
        Reminder instance = reminderRepository.findById(id).orElse(null);
        instance.setDescription(input.getDescription());
        instance.setTitle(input.getTitle());
        instance.setDate(input.getDate());

        return reminderRepository.save(instance);
    }
}
