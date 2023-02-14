package application;

import java.util.ArrayList;

public class NoteOrganizer {
	private ArrayList<Note> notes = new ArrayList<>();
	private String title;
	
	public NoteOrganizer(String title) {
		this.title = title;
	}
	
	public void sortBySubj(Subject subj) {
		for (Note n : notes) {
			if (n.getSubject().equals(subj)) {
				// code that shows the notes that match the subject
				System.out.println(n.getTitle()); // example
			}
		}
	}
}
