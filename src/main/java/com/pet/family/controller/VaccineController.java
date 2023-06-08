package com.pet.family.controller;

import com.pet.family.model.Vaccine;
import com.pet.family.payload.request.VaccineRequest;
import com.pet.family.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

    @Autowired
    private VaccineService vaccineService;

    @GetMapping("/{vaccineId}")
    public Vaccine getById(@PathVariable("vaccineId") Long vaccineId) {
        return vaccineService.findById(vaccineId);
    }

    @DeleteMapping(value = "/{vaccineId}")
    public void removeById(@PathVariable("vaccineId") Long vaccineId) {
        vaccineService.deleteById(vaccineId);
    }

    @GetMapping
    public List<Vaccine> list() {
        return vaccineService.findAll();
    }

    @GetMapping(value = "/pet/{petId}")
    public List<Vaccine> getByPetId(@PathVariable("petId") Long petId) {
        return vaccineService.vaccinesByPetId(petId);
    }

    @PostMapping
    public Vaccine create(@RequestBody VaccineRequest input) {
        return vaccineService.save(input);
    }

    @PutMapping(value = "/{vaccineId}")
    public Vaccine update(@PathVariable("vaccineId") Long vaccineId, @RequestBody VaccineRequest input) {
        return vaccineService.update(vaccineId, input);
    }
}
