package com.pet.family.controller;

import com.pet.family.model.Tip;
import com.pet.family.model.PetType;
import com.pet.family.payload.request.TipRequest;
import com.pet.family.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/tips")
public class TipController {
    @Autowired
    private TipService tipService;

    @GetMapping("/{tipId}")
    public Tip getById(@PathVariable("tipId") Long tipId) {
        return tipService.findById(tipId);
    }

    @DeleteMapping(value = "/{tipId}")
    public void removeById(@PathVariable("tipId") Long tipId) {
        tipService.deleteById(tipId);
    }

    @GetMapping
    public List<Tip> list() {
        return tipService.findAll();
    }

    @PostMapping
    public Tip create(@RequestBody TipRequest input) throws IOException {
        return tipService.save(input);
    }

    @PutMapping(value = "/{tipId}")
    public Tip update(@PathVariable("tipId") Long tipId, @RequestBody TipRequest input) {
        return tipService.update(tipId, input);
    }

    @GetMapping("/type")
    public List<Tip> getByType(@RequestBody String input) {
        PetType petType = PetType.ALL;
        switch (input) {
            case "dog":
                petType = PetType.DOG;
                break;
            case "cat":
                petType = PetType.CAT;
                break;
            case "mouse":
                petType = PetType.MOUSE;
                break;
            case "bird":
                petType = PetType.BIRD;
                break;
            case "fish":
                petType = PetType.FISH;
                break;
            default:
                petType = PetType.ALL;
                break;
        }

        return tipService.findByType(petType);
    }
}
