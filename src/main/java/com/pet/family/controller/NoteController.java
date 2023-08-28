package com.pet.family.controller;

import com.pet.family.model.Note;
import com.pet.family.payload.request.NoteRequest;
import com.pet.family.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/{noteId}")
    public Note getById(@PathVariable("noteId") Long noteId) {
        return noteService.findById(noteId);
    }

    @DeleteMapping(value = "/{noteId}")
    public void removeById(@PathVariable("noteId") Long noteId) {
        noteService.deleteById(noteId);
    }

    @GetMapping
    public List<Note> list() {
        return noteService.findAll();
    }

    @GetMapping(value = "/user/{userId}")
    public List<Note> getByUserId(@PathVariable("userId") Long userId) {
        return noteService.notesByUserId(userId);
    }

    @PostMapping
    public Note create(@RequestBody NoteRequest input) throws IOException {
        return noteService.save(input);
    }

    @PutMapping(value = "/{noteId}")
    public Note update(@PathVariable("noteId") Long noteId, @RequestBody NoteRequest input) {
        return noteService.update(noteId, input);
    }
}
