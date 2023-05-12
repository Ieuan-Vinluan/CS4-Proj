package application.model;

import java.util.ArrayList;

/**
 * The Note class represents a note that stores information that is important for the user. It has a title and content; it can also have an associated Subject.
 *
 * @author Ieuan Vinluan
 * @version 1.0
 */
public class Note {
	/**
	 * The content of the Note
	 */
	private String content;
	/**
	 * The associated Subject of the Note
	 */
	private Subject subject;
	/**
	 * The title of the Note
	 */
	private String title;
	/**
	 * An ArrayList containing all created Notes
	 */
	private static ArrayList<Note> notes = new ArrayList<>();

	/**
	 *
	 * @param title The title of the Note
	 * @param content The content of the Note
	 * @param subject The associated Subject of the Note
	 */
	public Note(String title, String content, Subject subject) {
		this.title = title;
		this.content = content;
		this.subject = subject;
		notes.add(this);
		for (Subject s : Subject.getSubjects()) {
			if (s.equals(this.subject)) s.getNotes().add(this);
		}
	}

	/**
	 * Returns the title of the Note
	 * @return the title of the Note
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the Note
	 * @param title the new title of the Note
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the content of the Note
	 * @return the content of the Note
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Sets the content of the Note
	 * @param content the new content of the Note
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Returns the associated Subject of the Note
	 * @return the Subject of the note
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the associated Subject of the Note
	 * @param subject the new Subject of the Note
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Returns the ArrayList of all created Notes
	 * @return the ArrayList of all created Notes
	 */
	public static ArrayList<Note> getNotes() {
		return notes;
	}

	/**
	 * Sets the ArrayList containing all Notes to another ArrayList containing Notes
	 * @param notes the new ArrayList of Notes
	 */
	public static void setNotes(ArrayList<Note> notes) {
		Note.notes = notes;
	}

	/**
	 * Removes the content of the Note by setting it to an empty string
	 */
	public void delete() {
		this.content = "";
	}
}
