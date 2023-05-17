package application.model;

import java.util.ArrayList;

/**
 * The Subject class represents a "course" that a student would have to go through in school. It has a subject name, an ArrayList of LearningGuides that the student can access, an ArrayList of Quizzes that the student can answer, and an ArrayList of Notes that are related to that Subject. In addition to this, each Subject has an image that is used to represent that particular Subject all throughout the app.
 */
public class Subject {
    /**
     * The name of the Subject
     */
    private String subjectName;
    /**
     * An ArrayList of LearningGuides that are related to this Subject
     */
    private ArrayList<LearningGuide> learningGuides = new ArrayList<>();
    /**
     * An ArrayList of Quizzes that are related to this Subject
     */
    private ArrayList<Quiz> quizzes = new ArrayList<>();
    /**
     * An ArrayList of Notes that are related to this Subject
     */
    private ArrayList<Note> notes = new ArrayList<>();
    /**
     * The file name of the image in the "images" directory that represents this Subject
     */
    private String imageFilename;
    /**
     * An ArrayList of all created Subjects
     */
    private static ArrayList<Subject> subjects = new ArrayList<>();

    /**
     * @param subjectName   the name of the Subject
     * @param imageFilename the file name of the image in the "images" directory that represents this Subject
     */
    public Subject(String subjectName, String imageFilename) {
        this.subjectName = subjectName;
        this.imageFilename = imageFilename;
        subjects.add(this);
    }

    /**
     * Returns the file name of the image in the "images" directory that represents this Subject
     *
     * @return the file name of the image in the "images" directory that represents this Subject
     */
    public String getImageFilename() {
        return imageFilename;
    }

    /**
     * Sets the file name of the image in the "images" directory that represents this Subject
     *
     * @param imageFilename the file name of the new image in the "images" directory that represents this Subject
     */
    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    /**
     * Returns the ArrayList of all created Subjects
     *
     * @return the ArrayList of all created Subjects
     */
    public static ArrayList<Subject> getSubjects() {
        return subjects;
    }

    /**
     * Sets the ArrayList of all created Subjects to another ArrayList that contains Subjects
     *
     * @param subjects another ArrayList that contains Subjects
     */
    public static void setSubjects(ArrayList<Subject> subjects) {
        Subject.subjects = subjects;
    }

    /**
     * Returns the name of the Subject
     *
     * @return the name of the Subject
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the name of the Subject
     *
     * @param subjectName the new name of the Subject
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * Returns the ArrayList of Quizzes associated with this Subject
     *
     * @return the ArrayList of Quizzes associated with this Subject
     */
    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     * Sets the ArrayList of Quizzes associated with this Subject to another ArrayList containing Quizzes
     *
     * @param quizzes another ArrayList containing Quizzes
     */
    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    /**
     * Returns the ArrayList of Notes associated with this Subject
     *
     * @return the ArrayList of Notes associated with this Subject
     */
    public ArrayList<Note> getNotes() {
        return notes;
    }

    /**
     * Sets the ArrayList of Notes associated with this Subject to another ArrayList containing Notes
     *
     * @param notes another ArrayList containing Notes
     */
    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    /**
     * Returns the ArrayList of LearningGuides associated with this Subject
     *
     * @return the ArrayList of LearningGuides associated with this Subject
     */
    public ArrayList<LearningGuide> getLearningGuides() {
        return learningGuides;
    }

    /**
     * Sets the ArrayList of LearningGuides associated with this Subject to another ArrayList containing LearningGuides
     *
     * @param learningGuides another ArrayList containing LearningGuides
     */
    public void setLearningGuides(ArrayList<LearningGuide> learningGuides) {
        this.learningGuides = learningGuides;
    }

}
