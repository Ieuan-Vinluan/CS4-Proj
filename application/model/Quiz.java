package application.model;

import java.util.ArrayList;

public class Quiz {
	private String quizID;
	private Subject subject;
	private ArrayList<Question> questions;
	private int currentScore = 0;
	private int highestPossibleScore = 0;
	
	public Quiz(String quizID, Subject subject, int highestPossibleScore) {
		this.quizID = quizID;
		this.subject = subject;
		this.highestPossibleScore = highestPossibleScore;
		this.questions = new ArrayList<Question>();
		for (Question q : Question.questions) {
			if (q.getQuiz().equals(this)) {
				questions.add(q);
			}
		}
	}

	public String getQuizID() {
		return quizID;
	}
	
	public void setQuizID(String quizID) {
		this.quizID = quizID;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question q) {
		this.questions.add(q);
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	public int getHighestPossibleScore() {
		return highestPossibleScore;
	}
	
	public void setHighestPossibleScore(int highestPossibleScore) {
		this.highestPossibleScore = highestPossibleScore;
	}
	
	public void startQuiz() {
		for (Question q : questions) {
			// show window that contains question
			
			String userAnswer = "";
			
			// take user input and store it in userAnswer
			
			q.answer(userAnswer);
		}
		
		// code that shows user score in window
	}
	
	public void quitQuiz() {
		// code that closes the quiz window
	}
}
