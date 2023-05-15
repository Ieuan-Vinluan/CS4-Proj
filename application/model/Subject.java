package application.model;

import java.util.ArrayList;

public class Subject {
    private String subjectName;
    private ArrayList<LearningGuide> learningGuides = new ArrayList<>();
    private ArrayList<Quiz> quizzes = new ArrayList<>();
    private ArrayList<Note> notes = new ArrayList<>();
    private String imageFilename;
    private static ArrayList<Subject> subjects = new ArrayList<>();

    public Subject(String subjectName, String imageFilename) {
        this.subjectName = subjectName;
        this.imageFilename = imageFilename;
        subjects.add(this);
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public static ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public static void setSubjects(ArrayList<Subject> subjects) {
        Subject.subjects = subjects;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    public void setQuizzes(ArrayList<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public ArrayList<LearningGuide> getLearningGuides() {
        return learningGuides;
    }

    public void setLearningGuides(ArrayList<LearningGuide> learningGuides) {
        this.learningGuides = learningGuides;
    }

    public void showContents() {
        int index = 1;
        for (LearningGuide lg : learningGuides) {
            System.out.println(index + ". " + lg.getTitle());
        }
    }

}
