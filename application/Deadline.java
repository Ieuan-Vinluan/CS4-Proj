package application;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Deadline {
	private String requirement;
	private Subject subject;
	private LocalDateTime deadline;
	
	public LocalDateTime getDeadline() {
		return deadline;
	}
	
	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}
	
	public String getRequirement() {
		return requirement;
	}
	
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	
	public void addToDeadlineList(DeadlineList deadlineList) {
		ArrayList<Deadline> dl = deadlineList.getDeadlines();
		dl.add(this);
		deadlineList.setDeadlines(dl);
	}
	
	public void removeFromDeadlineList(DeadlineList deadlineList) {
		if (!deadlineList.getDeadlines().contains(this)) return; 
		ArrayList<Deadline> dl = deadlineList.getDeadlines();
		dl.remove(this);
		deadlineList.setDeadlines(dl);
	}
}