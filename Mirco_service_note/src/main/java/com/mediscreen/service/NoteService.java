package com.mediscreen.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public List<Note> findNoteByPatientId(int patientId) {
		Sort sort = Sort.by(Sort.Direction.DESC, "date");
		return noteRepository.findAllNoteBypatientId(patientId, sort);
	}

	public Optional<Note> findNoteById(String noteId) {
		return noteRepository.findById(noteId);
	}

}
