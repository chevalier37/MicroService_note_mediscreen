package com.mediscreen.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Note")
public class Note {

	@Id
	private String id;

	@Field(value = "patientId")
	private int patientId;

	@Field(value = "note")
	private String note;

	@Field(value = "date")
	private LocalDate date;

	public Note(int patientId, String note, LocalDate date) {
		this.patientId = patientId;
		this.note = note;
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", patientId=" + patientId + ", note=" + note + "]";
	}

}