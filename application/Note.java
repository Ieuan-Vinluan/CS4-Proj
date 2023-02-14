package application;

public class Note {
	private String content;
	private Subject subject;
	private String title;
	
	public Note(String title, String content, Subject subject) {
		this.title = title;
		this.content = content;
		this.subject = subject;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void write(String text) {
		this.content = text;
	}
	
	public String getUserInput() {
		String text = "";
		
		// Code that gets user input and stores it in text
		
		return text;
	}
	
	public void delete() {
		this.content = "";
	}
}
