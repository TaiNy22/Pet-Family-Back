package com.pet.family.service;

import com.pet.family.model.VeterinaryDate;
import com.pet.family.payload.request.VeterinaryDateRequest;
import com.pet.family.repository.VeterinaryDateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tainy
 */
@Service
public class VeterinaryDateService implements IVeterinaryDateService {
    private VeterinaryDateRepository veterinaryDateRepository;

    public VeterinaryDateService(VeterinaryDateRepository veterinaryDateRepository) {
        this.veterinaryDateRepository = veterinaryDateRepository;
    }

    @Override
    public VeterinaryDate findById(Long id) {
        return veterinaryDateRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        veterinaryDateRepository.deleteById(id);
    }

    @Override
    public List<VeterinaryDate> findAll() {
        return veterinaryDateRepository.findAll();
    }

    @Override
    public VeterinaryDate save(VeterinaryDateRequest input) {
        VeterinaryDate instance = new VeterinaryDate();
        instance.setDate(input.getDate());
        instance.setHour(input.getHour());
        instance.setPlace(input.getPlace());
        instance.setDescription(input.getDescription());

        return veterinaryDateRepository.save(instance);
    }

    @Override
    public VeterinaryDate update(Long id, VeterinaryDateRequest input) {
        VeterinaryDate instance = veterinaryDateRepository.findById(id).orElse(null);
        instance.setDate(input.getDate());
        instance.setHour(input.getHour());
        instance.setPlace(input.getPlace());
        instance.setDescription(input.getDescription());

        return veterinaryDateRepository.save(instance);
    }
}
