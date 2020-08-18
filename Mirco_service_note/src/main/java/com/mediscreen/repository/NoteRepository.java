package com.mediscreen.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mediscreen.model.Note;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {

	@Query("{ 'patientId' : ?0 }")
	List<Note> findAllNoteBypatientId(String patientId, Sort sort);
}
