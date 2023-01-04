package com.pet.family.service;

import com.pet.family.model.User;
import com.pet.family.payload.request.UserRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface IUserService {
    public User findById(Long id);

    public void deleteById(Long id);

    public List<User> findAll();

    public User save(UserRequest input);

    public User update(Long id, UserRequest input);
}
