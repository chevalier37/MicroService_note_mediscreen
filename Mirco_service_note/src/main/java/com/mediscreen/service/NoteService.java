package com.mediscreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mediscreen.model.Note;
import com.mediscreen.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;

	public Note addNote(Note note) {
		return noteRepository.save(note);
	}

	public List<Note> findNoteByPatientId(String patientId) {
		return noteRepository.findAllNoteBypatientId(patientId);
	}

	public Optional<Note> findNoteById(String noteId) {
		return noteRepository.findById(noteId);
	}

}
