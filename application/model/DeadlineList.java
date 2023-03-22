package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class DeadlineList {

	private String deadlineListName;
	private ArrayList<Deadline> deadlines = new ArrayList<>();

	public DeadlineList(String deadlineListName) {
		this.deadlineListName = deadlineListName;
	}

	public String getDeadlineListName() {
		return deadlineListName;
	}

	public void setDeadlineListName(String deadlineListName) {
		this.deadlineListName = deadlineListName;
	}

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

	public static void sortDeadlineList(ArrayList<Deadline> deadlines, int low, int high, Deadline pivot) {

		// implementation of quick sort for deadlines

		if (low >= high) return;

		int left = low, right = high;

		while (left < right) {
			while (left < right && deadlines.get(left).getDeadline().isBefore(pivot.getDeadline())) {
				left += 1;
			}

			while (left < right && deadlines.get(right).getDeadline().isAfter(pivot.getDeadline())) {
				right -= 1;
			}

			swap(deadlines, left, right);
		}

		if (deadlines.get(left).getDeadline().isAfter(deadlines.get(high).getDeadline())) {
			swap(deadlines, left, high);
		} else {
			left = high;
		}

		sortDeadlineList(deadlines, low, left - 1, deadlines.get(left - 1));
		sortDeadlineList(deadlines, left + 1, high, deadlines.get(high));
	}

	private static void swap(ArrayList<Deadline> deadlines, int first, int second) {
		Deadline temp = deadlines.get(first);
		deadlines.set(first, deadlines.get(second));
		deadlines.set(second, temp);
	}
}
