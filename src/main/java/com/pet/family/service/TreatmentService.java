package com.pet.family.service;

import com.pet.family.model.Treatment;
import com.pet.family.payload.request.TreatmentRequest;
import com.pet.family.repository.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tainy
 */
@Service
public class TreatmentService implements ITreatmentService {
    private TreatmentRepository treatmentRepository;

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
    public List<Treatment> findAll() {
        return treatmentRepository.findAll();
    }

    @Override
    public Treatment save(TreatmentRequest input) {
        Treatment instance = new Treatment();
        instance.setDate(input.getDate());
        instance.setDescription(input.getDescription());
        instance.setHours(input.getHours());
        instance.setTitle(input.getTitle());

        return treatmentRepository.save(instance);
    }

    @Override
    public Treatment update(Long id, TreatmentRequest input) {
        Treatment instance = treatmentRepository.findById(id).orElse(null);
        instance.setDate(input.getDate());
        instance.setDescription(input.getDescription());
        instance.setHours(input.getHours());
        instance.setTitle(input.getTitle());

        return treatmentRepository.save(instance);
    }
}
