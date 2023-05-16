package application.model;

import java.util.ArrayList;

/**
 * The Quiz class represents a test with questions that must be answered by students. It has a quizID that identifies it, a Subject to which that Quiz belongs, an ArrayList of Questions that must be answered by students, a score, and a highest possible score.
 */
public class Quiz {
    /**
     * The ID of the quiz
     */
    private String quizID;
    /**
     * The Subject to which this Quiz belongs
     */
    private Subject subject;
    /**
     * The ArrayList of Questions contained by this Quiz
     */
    private ArrayList<Question> questions;
    /**
     * The current score of the student
     */
    private int currentScore = 0;
    /**
     * The highest possible score of the Quiz
     */
    private int highestPossibleScore = 0;
    /**
     * An ArrayList containing all created Quizzes
     */
    private static ArrayList<Quiz> quizzes = new ArrayList<>();

    /**
     *
     * @param quizID the ID of the Quiz
     * @param subject the Subject that contains this Quiz
     * @param highestPossibleScore the highest possible score of the Quiz
     */
    public Quiz(String quizID, Subject subject, int highestPossibleScore) {
        this.quizID = quizID;
        this.subject = subject;
        this.highestPossibleScore = highestPossibleScore;
        this.questions = new ArrayList<Question>();
        quizzes.add(this);
        for (Subject s : Subject.getSubjects()) {
            if (s.equals(this.subject)) {
                s.getQuizzes().add(this);
            }
        }
    }

    /**
     * Returns the ID of the Quiz
     * @return the ID of the Quiz
     */
    public String getQuizID() {
        return quizID;
    }

    /**
     * Sets the ID of the Quiz
     * @param quizID the new ID of the Quiz
     */
    public void setQuizID(String quizID) {
        this.quizID = quizID;
    }

    /**
     * Returns the Subject that contains this Quiz
     * @return the Subject that contains this Quiz
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Sets the Subject that contains this Quiz
     * @param subject the new Subject that will contain this Quiz
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /**
     * Returns the ArrayList of Questions that are contained by this Quiz
     * @return the ArrayList of Questions that are contained by this Quiz
     */
    public ArrayList<Question> getQuestions() {
        return questions;
    }

    /**
     * Sets the ArrayList of Questions that will be contained by this Quiz
     * @param questions the ArrayList of Questions that will be contained by this Quiz
     */
    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    /**
     * Adds a Question to the Quiz
     * @param q the Question to be added to the Quiz
     */
    public void addQuestion(Question q) {
        this.questions.add(q);
    }

    /**
     * Returns the current score of the student
     * @return the current score of the student
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * Sets the current score of the student
     * @param currentScore the new current score of the student
     */
    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    /**
     * Returns the highest possible score of the Quiz
     * @return the highest possible score of the Quiz
     */
    public int getHighestPossibleScore() {
        return highestPossibleScore;
    }

    /**
     * Sets the highest possible score of the Quiz
     * @param highestPossibleScore the new highest possible score of the Quiz
     */
    public void setHighestPossibleScore(int highestPossibleScore) {
        this.highestPossibleScore = highestPossibleScore;
    }

    /**
     * Returns the ArrayList containing all created Quizzes
     * @return the ArrayList containing all created quizzes
     */
    public static ArrayList<Quiz> getQuizzes() {
        return quizzes;
    }

    /**
     * Sets the ArrayList of all created Quizzes to another ArrayList containing Quizzes
     * @param quizzes the new ArrayList containing Quizzes
     */
    public static void setQuizzes(ArrayList<Quiz> quizzes) {
        Quiz.quizzes = quizzes;
    }
}
