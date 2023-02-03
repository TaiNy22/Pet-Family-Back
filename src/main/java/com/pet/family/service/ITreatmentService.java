package com.pet.family.service;

import com.pet.family.model.Treatment;
import com.pet.family.payload.request.TreatmentRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface ITreatmentService {
    public Treatment findById(Long id);

    public void deleteById(Long id);

    public List<Treatment> findAll();

    public Treatment save(TreatmentRequest input);

    public Treatment update(Long id, TreatmentRequest input);
}
