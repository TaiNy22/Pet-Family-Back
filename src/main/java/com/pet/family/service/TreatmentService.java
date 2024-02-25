package com.pet.family.service;

import com.pet.family.model.Pet;
import com.pet.family.model.Treatment;
import com.pet.family.model.User;
import com.pet.family.payload.request.TreatmentRequest;
import com.pet.family.payload.response.TreatmentResponse;
import com.pet.family.repository.PetRepository;
import com.pet.family.repository.TreatmentRepository;
import com.pet.family.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

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
        instance.setReminder(input.getReminder());

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
    public List<Treatment> treatmentsByPetId(Long petId) {
        Pet pet = petRepository.findById(petId).orElse(null);

        return treatmentRepository.findTreatmentsByPet(pet);
    }

    @Override
    public List<TreatmentResponse> treatmentsByUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        List<Pet> petsByUser = petRepository.findPetByUser(user);

        List<TreatmentResponse> treatments = new ArrayList<>();

        petsByUser.forEach(pet -> {
            List<Treatment> treatmentInstance = treatmentRepository.findTreatmentsByPet(pet);

            treatmentInstance.forEach(treatment -> {
                TreatmentResponse treatmentResponse = new TreatmentResponse();
                treatmentResponse.setId(treatment.getId());
                treatmentResponse.setDate(treatment.getDate());
                treatmentResponse.setDescription(treatment.getDescription());
                treatmentResponse.setCreatedDate(treatment.getCreatedDate());
                treatmentResponse.setNextDate(treatment.getNextDate());
                treatmentResponse.setTitle(treatment.getTitle());
                treatmentResponse.setPet(pet);

                treatments.add(treatmentResponse);
            });
        });

        return treatments;
    }
}
