package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.model.Vaccine;
import com.pet.family.payload.request.VaccineRequest;
import com.pet.family.payload.response.VaccineResponse;
import com.pet.family.repository.PetRepository;
import com.pet.family.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tainy
 */
@Service
public class VaccineService implements IVaccineService {
    private VaccineRepository vaccineRepository;

    @Autowired
    private PetRepository petRepository;

    public VaccineService(VaccineRepository vaccineRepository) {
        this.vaccineRepository = vaccineRepository;
    }

    @Override
    public Vaccine findById(Long id) {
        return vaccineRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        vaccineRepository.deleteById(id);
    }

    @Override
    public List<VaccineResponse> findAll() {
        List<Pet> pets = petRepository.findAll();

        List<VaccineResponse> vaccineResponses = new ArrayList<>();

        pets.forEach(pet -> {
            List<Vaccine> vaccines = vaccineRepository.findVaccinesByPet(pet);

            vaccines.forEach(vaccine -> {
                VaccineResponse instance = new VaccineResponse();

                instance.setId(vaccine.getId());
                instance.setType(vaccine.getType());
                instance.setDone(vaccine.isDone());
                instance.setCreatedDate(vaccine.getCreatedDate());
                instance.setDate(vaccine.getDate());
                instance.setPet(pet);

                vaccineResponses.add(instance);
            });
        });

        return vaccineResponses;
    }

    @Override
    public Vaccine save(VaccineRequest input) {
        Vaccine instance = new Vaccine();
        instance.setDate(input.getDate());
        instance.setDone(input.isDone());
        instance.setType(input.getType());

        Pet pet = petRepository.findById(input.getPetId()).orElse(null);
        instance.setPet(pet);

        return vaccineRepository.save(instance);
    }

    @Override
    public VaccineResponse update(Long id, VaccineRequest input) {
        Vaccine instance = vaccineRepository.findById(id).orElse(null);
        instance.setDate(input.getDate());
        instance.setDone(input.isDone());
        instance.setType(input.getType());

        Pet pet = petRepository.findById(input.getPetId()).orElse(null);
        instance.setPet(pet);

        vaccineRepository.save(instance);

        VaccineResponse response = new VaccineResponse();
        response.setId(instance.getId());
        response.setDate(instance.getDate());
        response.setDone(instance.isDone());
        response.setPet(pet);
        response.setType(instance.getType());

        return response;
    }

    @Override
    public List<Vaccine> vaccinesByPetId(Long userId) {
        Pet pet = petRepository.findById(userId).orElse(null);

        return vaccineRepository.findVaccinesByPet(pet);
    }
}
