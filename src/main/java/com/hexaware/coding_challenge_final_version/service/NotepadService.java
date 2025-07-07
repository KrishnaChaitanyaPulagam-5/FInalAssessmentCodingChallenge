package com.hexaware.coding_challenge_final_version.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.coding_challenge_final_version.model.Notepad;
import com.hexaware.coding_challenge_final_version.repository.NotepadRepository;

@Service
public class NotepadService {

    @Autowired
    private NotepadRepository notepadRepository;

    public Notepad addNote(Notepad notepad) {
        return notepadRepository.save(notepad);
    }

    public List<Notepad> getall() {
        return notepadRepository.findAll();
    }

    public Notepad EditNote(Notepad notepad, int id) {
        Notepad mainNote = notepadRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found"));
        String title = notepad.getTitle();
        String description = notepad.getDescription();
        if (notepad.getTitle() != null) {
            mainNote.setTitle(title);
        }
        if (notepad.getDescription() != null) {
            mainNote.setDescription(description);
        }
        return notepadRepository.save(mainNote);
    }

}
