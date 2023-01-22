package model;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DeadlineList {
	private ArrayList<Deadline> deadlines;
	
	public ArrayList<Deadline> getDeadlines() {
		return deadlines;
	}
	
	public void setDeadlines(ArrayList<Deadline> deadlines) {
		this.deadlines = deadlines;
	}
	
	public void compoundWithDeadlineList(DeadlineList deadlineList) {
		ArrayList<Deadline> newList = deadlineList.getDeadlines();
		newList.addAll(deadlines);
		deadlineList.setDeadlines(newList);
	}
	
	public void changeContentsDeadlines(LocalDateTime newDL) {
		for (Deadline d : deadlines) {
			d.setDeadline(newDL);
		}
	}
	
	public void removeFromDeadlineList(DeadlineList deadlineList) {
		ArrayList<Deadline> newList = deadlineList.getDeadlines();
		newList.removeAll(deadlines);
		deadlineList.setDeadlines(newList);
	}
}
