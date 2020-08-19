package com.mediscreen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {

	@Autowired
	NoteService noteService;

	@PostMapping("addNote")
	public Note addNote(@RequestBody Note note) {
		return noteService.addNote(note);
	}

	@GetMapping("listNote/{patientId}")
	public List<Note> listNotes(@PathVariable(value = "patientId") int patientId) {
		return noteService.findNoteByPatientId(patientId);
	}

	@GetMapping("getNote/{noteId}")
	public Note getNote(@PathVariable(value = "noteId") String noteId) {
		return noteService.findNoteById(noteId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid note Id:" + noteId));
	}

}
