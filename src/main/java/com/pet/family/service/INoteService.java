package com.pet.family.service;

import com.pet.family.model.Note;
import com.pet.family.payload.request.NoteRequest;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
public interface INoteService {

    public Note findById(Long id);

    public void deleteById(Long id);

    public List<Note> findAll();

    public Note save(NoteRequest input) throws IOException;

    public Note update(Long id, NoteRequest input);

    public List<Note> notesByUserId(Long userId);
}
