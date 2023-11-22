package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.model.Treatment;
import com.pet.family.model.Vaccine;
import com.pet.family.payload.request.TreatmentRequest;
import com.pet.family.payload.response.TreatmentResponse;
import com.pet.family.payload.response.VaccineResponse;
import com.pet.family.repository.PetRepository;
import com.pet.family.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tainy
 */
@Service
public class TreatmentService implements ITreatmentService {
    private TreatmentRepository treatmentRepository;

    @Autowired
    private PetRepository petRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public Treatment findById(Long id) {
        return treatmentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        treatmentRepository.deleteById(id);
    }

    @Override
    public List<TreatmentResponse> findAll() {
        List<Pet> pets = petRepository.findAll();
        List<TreatmentResponse> treatmentResponses = new ArrayList<>();

        pets.forEach(pet -> {
            List<Treatment> treatments = treatmentRepository.findTreatmentsByPet(pet);

            treatments.forEach(treatment -> {
                TreatmentResponse instance = new TreatmentResponse();

                instance.setId(treatment.getId());
                instance.setTitle(treatment.getTitle());
                instance.setDescription(treatment.getDescription());
                instance.setCreatedDate(treatment.getCreatedDate());
                instance.setDate(treatment.getDate());
                instance.setNextDate(treatment.getNextDate());
                instance.setPet(pet);

                treatmentResponses.add(instance);
            });
        });

        return treatmentResponses;
    }

    @Override
    public Treatment save(TreatmentRequest input) {
        Treatment instance = new Treatment();
        instance.setDate(input.getDate());
        instance.setNextDate(input.getNextDate());
        instance.setDescription(input.getDescription());
        instance.setTitle(input.getTitle());

        Pet pet = petRepository.findById(input.getPetId()).orElse(null);
        instance.setPet(pet);

        return treatmentRepository.save(instance);
    }

    @Override
    public TreatmentResponse update(Long id, TreatmentRequest input) {
        Treatment instance = treatmentRepository.findById(id).orElse(null);
        instance.setDate(input.getDate());
        instance.setNextDate(input.getNextDate());
        instance.setDescription(input.getDescription());
        instance.setTitle(input.getTitle());

        Pet pet = petRepository.findById(input.getPetId()).orElse(null);
        instance.setPet(pet);

        treatmentRepository.save(instance);

        TreatmentResponse response = new TreatmentResponse();
        response.setId(instance.getId());
        response.setDate(instance.getDate());
        response.setNextDate(instance.getNextDate());
        response.setDescription(instance.getDescription());
        response.setPet(pet);
        response.setTitle(instance.getTitle());

        return response;
    }

    @Override
    public List<Treatment> treatmentsByPetId(Long userId) {
        Pet pet = petRepository.findById(userId).orElse(null);

        return treatmentRepository.findTreatmentsByPet(pet);
    }
}
