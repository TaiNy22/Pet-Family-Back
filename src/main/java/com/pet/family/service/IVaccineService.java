package com.pet.family.service;

import com.pet.family.model.Vaccine;
import com.pet.family.payload.request.VaccineRequest;
import com.pet.family.payload.response.VaccineResponse;

import java.util.List;

/**
 * @author Tainy
 */
public interface IVaccineService {
    public Vaccine findById(Long id);

    public void deleteById(Long id);

    public List<VaccineResponse> findAll();

    public Vaccine save(VaccineRequest input);

    public Vaccine update(Long id, VaccineRequest input);

    List<Vaccine> vaccinesByPetId(Long petId);
}
