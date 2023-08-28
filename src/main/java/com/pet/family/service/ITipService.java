package com.pet.family.service;

import com.pet.family.model.Tip;
import com.pet.family.model.PetType;
import com.pet.family.payload.request.TipRequest;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
public interface ITipService {
    public Tip findById(Long id);

    public void deleteById(Long id);

    public List<Tip> findAll();

    public Tip save(TipRequest input) throws IOException;

    public Tip update(Long id, TipRequest input);

    public List<Tip> findByType(PetType input);
}
