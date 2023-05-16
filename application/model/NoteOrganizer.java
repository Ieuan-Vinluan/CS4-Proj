package application.model;

import java.util.ArrayList;

/**
 * The NoteOrganizer class represents a container of Notes. It has an ArrayList of the Notes that it contains and a String that serves as its name or title.
 */
public class NoteOrganizer {
    /**
     * The ArrayList of Notes that the NoteOrganizer contains
     */
    private ArrayList<Note> notes = new ArrayList<>();
    /**
     * The title, or name, of the NoteOrganizer
     */
    private String title;

    /**
     * @param title the title, or name, of the NoteOrganizer
     */
    public NoteOrganizer(String title) {
        this.title = title;
    }

    /**
     * Prints the titles of the Notes that are associated with the given Subject
     *
     * @param subj the Subject that will be searched for in the Notes contained by the NoteOrganizer
     */
    public void sortBySubj(Subject subj) {
        for (Note n : notes) {
            if (n.getSubject().equals(subj)) {
                System.out.println(n.getTitle());
            }
        }
    }
}
