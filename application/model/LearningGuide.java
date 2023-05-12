package application.model;

import java.util.ArrayList;

/**
 * The LearningGuide class represents guides that will aid the User in studying. It is associated with a Subject and has a title, content, and a string that represents the file path that points to an image that is associated with the LearningGuide's Subject.
 */
public class LearningGuide {
	/**
	 * The title of the LearningGuide
	 */
	private String title;
	/**
	 * The associated Subject of the LearningGuide
	 */
	private Subject subject;
	/**
	 * The content of the LearningGuide
	 */
	private String content;
	/**
	 * The string representation of the file path of the image of the LearningGuide's associated Subject
	 */
	private String imageFN;
	/**
	 * The ArrayList containing all created LearningGuides
	 */
	private static ArrayList<LearningGuide> learningGuides = new ArrayList<>();

	/**
	 * Returns the title of the LearningGuide
	 * @return the title of the LearningGuide
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title of the LearningGuide
	 * @param title the new title of the LearningGuide
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Returns the associated Subject of the LearningGuide
	 * @return the associated Subject of the LearningGuide
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the Subject of the LearningGuide
	 * @param subject the new Subject to be associated with the LearningGuide
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageFN() {
		return imageFN;
	}

	public void setImageFN(String imageFN) {
		this.imageFN = imageFN;
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

	public LearningGuide(String title, Subject subject, String content, String imageFN) {
		this.title = title;
		this.subject = subject;
		this.content = content;
		this.imageFN = imageFN;
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
}