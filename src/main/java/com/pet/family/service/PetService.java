package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.model.User;
import com.pet.family.payload.request.PetRequest;
import com.pet.family.repository.PetRepository;
import com.pet.family.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tainy
 */
@Service
public class PetService implements IPetService {
    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Long id) {
        return petRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @Override
    public Pet save(PetRequest input) {
        Pet instance = new Pet();
        instance.setAge(input.getAge());
        instance.setName(input.getName());
        instance.setGender(input.getGender());
        instance.setAvatar(input.getAvatar());
        instance.setSterilization(input.getSterilization());
        instance.setWeight(input.getWeight());
        instance.setType(input.getType());

        User user = userRepository.findById(input.getUserId()).orElse(null);
        instance.setUser(user);

        return petRepository.save(instance);
    }

    @Override
    public Pet update(Long id, PetRequest input) {
        Pet instance = petRepository.findById(id).orElse(null);
        instance.setAge(input.getAge());
        instance.setName(input.getName());
        instance.setGender(input.getGender());
        instance.setAvatar(input.getAvatar());
        instance.setSterilization(input.getSterilization());
        instance.setWeight(input.getWeight());
        instance.setType(input.getType());

        return petRepository.save(instance);
    }

    @Override
    public List<Pet> petsByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        return petRepository.findPetByUser(user);
    }
}
