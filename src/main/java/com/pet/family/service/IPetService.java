package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.payload.request.PetRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface IPetService {
    public Pet findById(Long id);

    public void deleteById(Long id);

    public List<Pet> findAll();

    public Pet save(PetRequest input);

    public Pet update(Long id, PetRequest input);

    List<Pet> petsByUserId(Long userId);
}
