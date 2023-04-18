package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Deadline {
	private String requirement;
	private Subject subject;

	private DeadlineList deadlineList;
	private LocalDateTime deadline;

	private static ArrayList<Deadline> deadlines = new ArrayList<>();

	public Deadline(String requirement, Subject subject, DeadlineList deadlineList, LocalDateTime deadline) {
		this.requirement = requirement;
		this.subject = subject;
		this.deadlineList = deadlineList;
		this.deadline = deadline;
		deadlines.add(this);
		deadlineList.getDeadlines().add(this);
	}

	public Deadline(String requirement, Subject subject, LocalDateTime deadline) {
		this.requirement = requirement;
		this.subject = subject;
		this.deadline = deadline;
		deadlines.add(this);
	}

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

	public DeadlineList getDeadlineList() {
		return deadlineList;
	}

	public void setDeadlineList(DeadlineList deadlineList) {
		this.deadlineList = deadlineList;
	}

	public static ArrayList<Deadline> getDeadlines() {
		return deadlines;
	}

	public static void setDeadlines(ArrayList<Deadline> deadlines) {
		Deadline.deadlines = deadlines;
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