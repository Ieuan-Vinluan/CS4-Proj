package application.model;

import java.util.ArrayList;

public class Quiz {
	private String quizID;
	private Subject subject;
	private ArrayList<Question> questions;
	private int currentScore = 0;
	private int highestPossibleScore = 0;
	private static ArrayList<Quiz> quizzes = new ArrayList<>();
	
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

	public static ArrayList<Quiz> getQuizzes() {
		return quizzes;
	}

	public static void setQuizzes(ArrayList<Quiz> quizzes) {
		Quiz.quizzes = quizzes;
	}
}
