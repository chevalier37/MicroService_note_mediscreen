package com.mediscreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;

@RestController
public class NoteController {

	@Autowired
	NoteService noteService;

	@PostMapping("addNote")
	public Note addNote(@RequestBody Note note) {
		System.out.println(note);
		return noteService.addNote(note);
	}

	@GetMapping("listNote/{patientId}")
	public List<Note> listNotes(@PathVariable(value = "patientId") String patientId) {
		return noteService.findNoteByPatientId(patientId);
	}

}
