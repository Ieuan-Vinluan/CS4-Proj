package model;
import java.util.Scanner;

public class Note {
	private String content;
	private Subject subject;
	
	public Note(Subject subject) {
		this.content = "";
		this.subject = subject;
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
		
		/* Code that gets user input
		 * For example, here, Scanner was used to do so.
		 */
		
		Scanner s = new Scanner(System.in);
		
		text = s.nextLine();
		
		return text;
	}
	
	public void delete() {
		this.content = "";
	}
}
