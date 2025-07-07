package com.hexaware.coding_challenge_final_version.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.coding_challenge_final_version.model.Notepad;

public interface NotepadRepository extends JpaRepository<Notepad, Integer> {

}
