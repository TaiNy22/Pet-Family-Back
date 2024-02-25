package com.pet.family.service;

import com.pet.family.model.Treatment;
import com.pet.family.payload.request.TreatmentRequest;
import com.pet.family.payload.response.TreatmentResponse;

import java.util.List;

/**
 * @author Tainy
 */
public interface ITreatmentService {
    public Treatment findById(Long id);

    public void deleteById(Long id);

    public List<TreatmentResponse> findAll();

    public Treatment save(TreatmentRequest input);

    public TreatmentResponse update(Long id, TreatmentRequest input);

    List<Treatment> treatmentsByPetId(Long petId);

    List<TreatmentResponse> treatmentsByUser(Long userId);
}
