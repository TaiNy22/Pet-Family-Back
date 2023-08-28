package com.pet.family.repository;

import com.pet.family.model.Note;
import com.pet.family.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Tainy
 */
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findNotesByUser(User user);
}
