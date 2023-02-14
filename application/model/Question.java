package application.model;

import java.util.ArrayList;

public class Question {
	private Quiz quiz;
	private String question;
	private String answer;
	public static ArrayList<Question> questions = new ArrayList<Question>();
	
	public Question(Quiz quiz, String question, String answer) {
		this.quiz = quiz;
		this.question = question;
		this.answer = answer;
		questions.add(this);
	}
	
	public Quiz getQuiz() {
		return quiz;
	}
	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public void showAnswer() {
		System.out.println("Answer: " + answer);
	}
	
	
	
	public void answer(String ans) {
		if (ans.equalsIgnoreCase(answer)) {
			System.out.println("You got it right! The answer was: " + ans);
			quiz.setCurrentScore(quiz.getCurrentScore() + 1);
		} else {
			System.out.println("You got it wrong. The answer was: " + ans);
		}
	}
}
