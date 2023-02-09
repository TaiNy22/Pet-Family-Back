package com.pet.family.controller;

import com.pet.family.model.Tip;
import com.pet.family.model.TipType;
import com.pet.family.payload.request.TipRequest;
import com.pet.family.service.TipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Tip create(@RequestBody TipRequest input) {
        return tipService.save(input);
    }

    @PutMapping(value = "/{tipId}")
    public Tip update(@PathVariable("tipId") Long tipId, @RequestBody TipRequest input) {
        return tipService.update(tipId, input);
    }

    @GetMapping("/type")
    public List<Tip> getByType(@RequestBody String input) {
        TipType tipType = TipType.ALL;
        switch (input) {
            case "dog":
                tipType = TipType.DOG;
                break;
            case "cat":
                tipType = TipType.CAT;
                break;
            case "mouse":
                tipType = TipType.MOUSE;
                break;
            case "bird":
                tipType = TipType.BIRD;
                break;
            case "fish":
                tipType = TipType.FISH;
                break;
            default:
                tipType = TipType.ALL;
                break;
        }

        return tipService.findByType(tipType);
    }
}
