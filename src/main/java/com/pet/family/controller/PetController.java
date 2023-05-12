package com.pet.family.controller;

import com.pet.family.model.Pet;
import com.pet.family.payload.request.PetRequest;
import com.pet.family.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/{petId}")
    public Pet getById(@PathVariable("petId") Long petId) {
        return petService.findById(petId);
    }

    @DeleteMapping(value = "/{petId}")
    public void removeById(@PathVariable("petId") Long petId) {
        petService.deleteById(petId);
    }

    @GetMapping
    public List<Pet> list() {
        return petService.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<Pet> getByUserId(@PathVariable("userId") Long userId) {
        return petService.petsByUserId(userId);
    }

    @PostMapping
    public void create(@RequestBody PetRequest input) {
        petService.save(input);
    }

    @PutMapping(value = "/{petId}")
    public Pet update(@PathVariable("petId") Long petId, @RequestBody PetRequest input) {
        return petService.update(petId, input);
    }
}
