package com.pet.family.controller;

import com.pet.family.model.VeterinaryDate;
import com.pet.family.payload.request.VeterinaryDateRequest;
import com.pet.family.service.VeterinaryDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/veterinary_dates")
public class VeterinaryDateController {
    @Autowired
    private VeterinaryDateService veterinaryDateService;

    @GetMapping("/{veterinaryDateId}")
    public VeterinaryDate getById(@PathVariable("veterinaryDateId") Long veterinaryDateId) {
        return veterinaryDateService.findById(veterinaryDateId);
    }

    @DeleteMapping(value = "/{veterinaryDateId}")
    public void removeById(@PathVariable("veterinaryDateId") Long veterinaryDateId) {
        veterinaryDateService.deleteById(veterinaryDateId);
    }

    @GetMapping
    public List<VeterinaryDate> list() {
        return veterinaryDateService.findAll();
    }

    @PostMapping
    public VeterinaryDate create(@RequestBody VeterinaryDateRequest input) {
        return veterinaryDateService.save(input);
    }

    @PutMapping(value = "/{veterinaryDateId}")
    public VeterinaryDate update(@PathVariable("veterinaryDateId") Long veterinaryDateId, @RequestBody VeterinaryDateRequest input) {
        return veterinaryDateService.update(veterinaryDateId, input);
    }
}
