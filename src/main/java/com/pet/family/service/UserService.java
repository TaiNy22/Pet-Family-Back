package com.pet.family.service;

import com.pet.family.model.Role;
import com.pet.family.model.User;
import com.pet.family.model.UserRol;
import com.pet.family.payload.request.UserRequest;
import com.pet.family.repository.RoleRepository;
import com.pet.family.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tainy
 */
@Service
public class UserService implements IUserService {
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(UserRequest input) {
        User instance = new User();
        instance.setUsername(input.getUsername());
        instance.setName(input.getName());
        instance.setLastname(input.getLastname());
        instance.setPassword(encoder.encode(input.getPassword()));
        instance.setEmail(input.getEmail());
        instance.setCity(input.getCity());
        instance.setPhone(input.getPhone());

        Set<String> strRoles = new HashSet<>();
        strRoles.add(input.getRole());
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(UserRol.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(UserRol.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = roleRepository.findByName(UserRol.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        instance.setRoles(roles);

        return userRepository.save(instance);
    }

    @Override
    public User update(Long id, UserRequest input) {
        User instance = userRepository.findById(id).orElse(null);
        instance.setUsername(input.getUsername());
        instance.setName(input.getName());
        instance.setLastname(input.getLastname());
        instance.setPassword(encoder.encode(input.getPassword()));
        instance.setEmail(input.getEmail());
        instance.setPhone(input.getPhone());
        instance.setCity(input.getCity());

        Set<String> strRoles = new HashSet<>();
        strRoles.add(input.getRole());
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(UserRol.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(UserRol.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;
                    case "user":
                        Role userRole = roleRepository.findByName(UserRol.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        instance.setRoles(roles);

        return userRepository.save(instance);
    }
}
