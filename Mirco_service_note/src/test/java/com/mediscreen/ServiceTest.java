package com.mediscreen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ServiceTest {

	@Autowired
	private NoteService noteService;

	@Test
	public void addNoteTest() {
		Note note = new Note(50, "note test", LocalDate.now());
		noteService.addNote(note);
		List<Note> getNote = noteService.findNoteByPatientId(50);
		assertTrue(getNote.size() > 0);
	};

	@Test
	public void findNoteByIdTest() {
		Note note = new Note(50, "note test", LocalDate.now());
		noteService.addNote(note);
		List<Note> getNoteList = noteService.findNoteByPatientId(50);
		Note getNote = getNoteList.get(0);

		String id = getNote.getId();
		Note findbyIdNote = noteService.findNoteById(id).get();
		assertEquals(findbyIdNote.getPatientId(), 50);
	};
}
