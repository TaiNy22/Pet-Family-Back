package com.pet.family.controller;

import com.pet.family.model.User;
import com.pet.family.payload.request.UserRequest;
import com.pet.family.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User getById(@PathVariable("userId") Long userId) {
        return userService.findById(userId);
    }

    @DeleteMapping(value = "/{userId}")
    public void removeById(@PathVariable("userId") Long userId) {
        userService.deleteById(userId);
    }

    @GetMapping
    public List<User> list() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody UserRequest input) {
        return userService.save(input);
    }

    @PutMapping(value = "/{userId}")
    public User updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequest input) {
        return userService.update(userId, input);
    }
}

