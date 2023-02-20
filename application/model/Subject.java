package application.model;

import java.util.ArrayList;

public class Subject {
	private String subjectName;
	private ArrayList<LearningGuide> learningGuides;
	private ArrayList<Question> questions;
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
