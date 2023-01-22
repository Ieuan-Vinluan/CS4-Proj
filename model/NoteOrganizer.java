package model;
import java.util.ArrayList;

public class NoteOrganizer {
	private ArrayList<Note> notes = new ArrayList<>();
	
	public void sortBySubj(Subject subj) {
		for (Note n : notes) {
			if (n.getSubject().equals(subj)) {
				// code that shows the notes that match the subject
			}
		}
	}
}
