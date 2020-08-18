package com.mediscreen.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Note")
public class Note {

	@Id
	private String id;

	@Field(value = "patientId")
	private String patientId;

	@Field(value = "note")
	private String note;

	@Field(value = "date")
	private Date date;

	public Note(String patientId, String note, Date date) {
		super();
		this.patientId = patientId;
		this.note = note;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
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