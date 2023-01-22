package model;
import java.util.ArrayList;

public class Quiz {
	private String quizID;
	private String subject;
	private ArrayList<Question> questions;
	
	public Quiz(String quizID, String subject) {
		this.quizID = quizID;
		this.subject = subject;
		this.questions = new ArrayList<Question>();
		for (Question q : Question.questions) {
			if (q.getQuizID().equals(this.quizID)) {
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
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
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
	
	public void startQuiz() {
		for (Question q : questions) {
			System.out.println(q.getQuestion());
		}
	}
	
	public void quitQuiz() {
		
	}
	
}
