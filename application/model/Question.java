package application.model;

import java.util.ArrayList;

/**
 * The Question class represents a question on a Quiz. It has a Quiz that contains it, a String representing what is being asked, and a String representing the answer to what is being asked.
 */
public class Question {
    /**
     * The Quiz that contains this Question
     */
    private Quiz quiz;
    /**
     * The question What this Question object is asking for the answer to
     */
    private String question;
    /**
     * The answer to the question
     */
    private String answer;
    /**
     * An ArrayList containing all created Questions
     */
    public static ArrayList<Question> questions = new ArrayList<Question>();

    /**
     * @param quiz     the Quiz that contains this Question
     * @param question the question is being asked
     * @param answer   the answer to the question
     */
    public Question(Quiz quiz, String question, String answer) {
        this.quiz = quiz;
        this.question = question;
        this.answer = answer;
        questions.add(this);
        for (Quiz q : Quiz.getQuizzes()) {
            if (q.equals(this.quiz)) {
                q.addQuestion(this);
            }
        }
    }

    /**
     * Returns the Quiz that contains this Question
     *
     * @return the Quiz that contains this Question
     */
    public Quiz getQuiz() {
        return quiz;
    }

    /**
     * Sets the Quiz that contains this Question
     *
     * @param quiz the new Quiz that will contain this Question
     */
    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    /**
     * Returns the question that is being asked
     *
     * @return the question that is being asked
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the question that is being asked
     *
     * @param question the question that is being asked
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Returns the answer to the question
     *
     * @return the answer to the question
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer to the question
     *
     * @param answer the new answer to the question
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Prints the answer to the Question
     */
    public void showAnswer() {
        System.out.println("Answer: " + answer);
    }
}
