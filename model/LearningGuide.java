package model;
public class LearningGuide {
	private String title;
	private String subject;
	private String content;
		
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public LearningGuide(String title, String subject, String content) {
		this.title = title;
		this.subject = subject;
		this.content = content;
	}

	public void showContents() {
		System.out.println(getContent());
	}
}