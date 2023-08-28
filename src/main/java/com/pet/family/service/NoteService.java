package com.pet.family.service;

import com.pet.family.model.Note;
import com.pet.family.model.User;
import com.pet.family.payload.request.NoteRequest;
import com.pet.family.repository.NoteRepository;
import com.pet.family.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author Tainy
 */
@Service
public class NoteService implements INoteService {
    private NoteRepository noteRepository;

    @Autowired
    private UserRepository userRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note save(NoteRequest input) throws IOException {
        Note instance = new Note();
        instance.setTitle(input.getTitle());
        instance.setDescription(input.getDescription());

        User user = userRepository.findById(input.getUserId()).orElse(null);
        instance.setUser(user);

        return noteRepository.save(instance);
    }

    @Override
    public Note update(Long id, NoteRequest input) {
        Note instance = noteRepository.findById(id).orElse(null);
        instance.setTitle(input.getTitle());
        instance.setDescription(input.getDescription());

        User user = userRepository.findById(input.getUserId()).orElse(null);
        instance.setUser(user);

        return noteRepository.save(instance);
    }

    @Override
    public List<Note> notesByUserId(Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        return noteRepository.findNotesByUser(user);
    }
}
