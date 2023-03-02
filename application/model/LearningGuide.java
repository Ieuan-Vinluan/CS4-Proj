package application.model;

import java.util.ArrayList;

public class LearningGuide {
	private String title;
	private Subject subject;
	private String content;

	private static ArrayList<LearningGuide> learningGuides = new ArrayList<>();
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public LearningGuide(String title, Subject subject, String content) {
		this.title = title;
		this.subject = subject;
		this.content = content;
		learningGuides.add(this);
		for (Subject s : Subject.getSubjects()) {
			if (s.equals(this.subject)) {
				s.getLearningGuides().add(this);
			}
		}
	}

	public static ArrayList<LearningGuide> getLearningGuides() {
		return learningGuides;
	}

	public static void setLearningGuides(ArrayList<LearningGuide> learningGuides) {
		LearningGuide.learningGuides = learningGuides;
	}

	public void showContents() {
		// code that shows a window containing this.content
	}
	
	public void showOtherFromSubj() {
		ArrayList<LearningGuide> others = this.subject.getLearningGuides();
		others.remove(this);
		
		// code that shows the LearningGuides in others
	}
}