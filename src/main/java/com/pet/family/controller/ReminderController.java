package com.pet.family.controller;

import com.pet.family.model.Reminder;
import com.pet.family.payload.request.ReminderRequest;
import com.pet.family.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    @Autowired
    private ReminderService reminderService;

    @GetMapping("/{reminderId}")
    public Reminder getById(@PathVariable("reminderId") Long reminderId) {
        return reminderService.findById(reminderId);
    }

    @DeleteMapping(value = "/{reminderId}")
    public void removeById(@PathVariable("reminderId") Long reminderId) {
        reminderService.deleteById(reminderId);
    }

    @GetMapping
    public List<Reminder> list() {
        return reminderService.findAll();
    }

    @PostMapping
    public Reminder create(@RequestBody ReminderRequest input) {
        return reminderService.save(input);
    }

    @PutMapping(value = "/{reminderId}")
    public Reminder update(@PathVariable("reminderId") Long reminderId, @RequestBody ReminderRequest input) {
        return reminderService.update(reminderId, input);
    }
}
