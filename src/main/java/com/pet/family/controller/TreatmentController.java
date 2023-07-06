package com.pet.family.controller;

import com.pet.family.model.Treatment;
import com.pet.family.payload.request.TreatmentRequest;
import com.pet.family.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/{treatmentId}")
    public Treatment getById(@PathVariable("treatmentId") Long treatmentId) {
        return treatmentService.findById(treatmentId);
    }

    @DeleteMapping(value = "/{treatmentId}")
    public void removeById(@PathVariable("treatmentId") Long treatmentId) {
        treatmentService.deleteById(treatmentId);
    }

    @GetMapping
    public List<Treatment> list() {
        return treatmentService.findAll();
    }

    @GetMapping(value = "/pet/{petId}")
    public List<Treatment> getByPetId(@PathVariable("petId") Long petId) {
        return treatmentService.treatmentsByPetId(petId);
    }

    @PostMapping
    public Treatment create(@RequestBody TreatmentRequest input) {
        return treatmentService.save(input);
    }

    @PutMapping(value = "/{treatmentId}")
    public Treatment update(@PathVariable("treatmentId") Long treatmentId, @RequestBody TreatmentRequest input) {
        return treatmentService.update(treatmentId, input);
    }
}
