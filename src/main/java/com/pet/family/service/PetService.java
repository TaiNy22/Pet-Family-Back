package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.payload.request.PetRequest;
import com.pet.family.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tainy
 */
@Service
public class PetService implements IPetService {
    private PetRepository petRepository;

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
}
