package com.mediscreen;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.mediscreen.controller.NoteController;
import com.mediscreen.model.Note;
import com.mediscreen.service.NoteService;

@WebMvcTest(NoteController.class)
@ExtendWith(SpringExtension.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	NoteService noteService;

	@Test
	public void listNoteTest() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/note/listNote/1")).andExpect(status().isOk());
	}

	@Test
	public void getNoteTest() throws Exception {
		Note note = new Note(50, "note test", LocalDate.now());
		Mockito.when(noteService.findNoteById("5f3bcaf760fcf35d75eba60b")).thenReturn(Optional.of(note));
		this.mockMvc.perform(MockMvcRequestBuilders.get("/note/getNote/5f3bcaf760fcf35d75eba60b"))
				.andExpect(status().isOk());
	}

	@Test
	public void addNoteTest() throws Exception {
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/note/addNote").contentType(MediaType.APPLICATION_JSON).content(
						"{\"patientId\": \"50\",\"note\": \"controller test\",\"date\": \"2012-04-23T18:25:43.511Z\"}")
						.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}

}
