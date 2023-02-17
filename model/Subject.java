package application.model;

import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private ArrayList<LearningGuide> learningGuides;
	private ArrayList<Question> questions;
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
