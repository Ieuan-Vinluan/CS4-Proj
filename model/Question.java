package model;
import java.util.ArrayList;

public class Question {
	private String quizID;
	private String question;
	private String answer;
	public static ArrayList<Question> questions = new ArrayList<Question>();
	
	public Question(String quizID, String question, String answer) {
		this.quizID = quizID;
		this.question = question;
		this.answer = answer;
		questions.add(this);
	}
	
	public Question() {
		
	}
	
	public String getQuizID() {
		return quizID;
	}

	public void setQuizID(String quizID) {
		this.quizID = quizID;
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
		} else {
			System.out.println("You got it wrong. The answer was: " + ans);
		}
	}
}
