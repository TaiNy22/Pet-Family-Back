package com.pet.family.service;

import com.pet.family.model.Vaccine;
import com.pet.family.payload.request.VaccineRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface IVaccineService {
    public Vaccine findById(Long id);

    public void deleteById(Long id);

    public List<Vaccine> findAll();

    public Vaccine save(VaccineRequest input);

    public Vaccine update(Long id, VaccineRequest input);
}
