package com.pet.family.service;

import com.pet.family.model.PetType;
import com.pet.family.model.Tip;
import com.pet.family.payload.request.TipRequest;
import com.pet.family.repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
@Service
public class TipService implements ITipService {
    private TipRepository tipRepository;

    @Autowired
    private UploadFileService uploadFileService;

    public TipService(TipRepository tipRepository) {
        this.tipRepository = tipRepository;
    }

    @Override
    public Tip findById(Long id) {
        return tipRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        tipRepository.deleteById(id);
    }

    @Override
    public List<Tip> findAll() {
        return tipRepository.findAll();
    }

    @Override
    public Tip save(TipRequest input) throws IOException {
        Tip instance = new Tip();
        instance.setContent(input.getContent());
        instance.setTitle(input.getTitle());
        instance.setType(input.getType());

//        if (!input.getImage().isEmpty()) {
//            if (input.getImage() != null) {
//                uploadFileService.delete(input.getTitle());
//            }
//        }

//        String uniqueFileName = uploadFileService.copy(input.getImage());
//        instance.setImage(uniqueFileName);

        return tipRepository.save(instance);
    }

    @Override
    public Tip update(Long id, TipRequest input) {
        Tip instance = tipRepository.findById(id).orElse(null);
        instance.setContent(input.getContent());
        instance.setTitle(input.getTitle());
        instance.setType(input.getType());

        return tipRepository.save(instance);
    }

    @Override
    public List<Tip> findByType(PetType input) {
        return tipRepository.findTipByType(input);
    }

    @Override
    public Tip findRandom() {
        List<Tip> list = tipRepository.findAll();
        int tipIndex = (int)(Math.random()*list.size());
        return tipRepository.getById(list.get(tipIndex).getId());
    }
}
