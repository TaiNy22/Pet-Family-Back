package com.pet.family.service;

import com.pet.family.model.VeterinaryDate;
import com.pet.family.payload.request.VeterinaryDateRequest;

import java.util.List;

/**
 * @author Tainy
 */
public interface IVeterinaryDateService {
    public VeterinaryDate findById(Long id);

    public void deleteById(Long id);

    public List<VeterinaryDate> findAll();

    public VeterinaryDate save(VeterinaryDateRequest input);

    public VeterinaryDate update(Long id, VeterinaryDateRequest input);
}
