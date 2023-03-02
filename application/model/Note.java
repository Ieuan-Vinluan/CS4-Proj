package application.model;

import java.util.ArrayList;

public class Note {
	private String content;
	private Subject subject;
	private String title;
	private static ArrayList<Note> notes = new ArrayList<>();
	
	public Note(String title, String content, Subject subject) {
		this.title = title;
		this.content = content;
		this.subject = subject;
		notes.add(this);
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public static ArrayList<Note> getNotes() {
		return notes;
	}

	public static void setNotes(ArrayList<Note> notes) {
		Note.notes = notes;
	}

	public void write(String text) {
		this.content = text;
	}
	
	public String getUserInput() {
		String text = "";
		
		// Code that gets user input and stores it in text
		
		return text;
	}
	
	public void delete() {
		this.content = "";
	}
}
