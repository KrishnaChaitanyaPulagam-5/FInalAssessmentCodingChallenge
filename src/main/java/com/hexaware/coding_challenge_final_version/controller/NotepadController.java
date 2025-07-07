package com.hexaware.coding_challenge_final_version.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.coding_challenge_final_version.model.Notepad;
import com.hexaware.coding_challenge_final_version.service.NotepadService;

@RestController
@RequestMapping("/api/notepad")
public class NotepadController {

    @Autowired
    private NotepadService notepadService;

    @PostMapping("/addNote")
    public Notepad addNote(@RequestBody Notepad notepad) {
        return notepadService.addNote(notepad);
    }

    @GetMapping("/getAll")
    public List<Notepad> getall() {
        return notepadService.getall();
    }

    @PutMapping("/editnote/{id}")
    public Notepad EditNote(@RequestBody Notepad notepad, @PathVariable int id) {
        return notepadService.EditNote(notepad, id);
    }

}
