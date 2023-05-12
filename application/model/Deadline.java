package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The Deadline class represents a deadline and the requirement associated with that deadline. It can contain the Subject that the requirement is associated with and is itself contained in a DeadlineList.
 *
 * @author Ieuan Vinluan
 * @version 1.0
 */
public class Deadline {
	/**
	 * The name of the requirement
	 */
	private String requirement;
	/**
	 * The Subject that the requirement is associated with
	 */
	private Subject subject;
	/**
	 * The DeadlineList that will contain the Deadline
	 */
	private DeadlineList deadlineList;
	/**
	 * The date and time of the deadline
	 */
	private LocalDateTime deadline;
	/**
	 * An ArrayList of all created Deadlines
	 */
	private static ArrayList<Deadline> deadlines = new ArrayList<>();

	/**
	 *
	 * @param requirement The name of the requirement
	 * @param subject The Subject associated with the requirement
	 * @param deadlineList The DeadlineList containing the Deadline
	 * @param deadline The date and time of the deadline
	 */
	public Deadline(String requirement, Subject subject, DeadlineList deadlineList, LocalDateTime deadline) {
		this.requirement = requirement;
		this.subject = subject;
		this.deadlineList = deadlineList;
		this.deadline = deadline;
		deadlines.add(this);
		deadlineList.getDeadlines().add(this);
	}

	/**
	 *
	 * @param requirement The name of the requirement
	 * @param subject The Subject associated with the requirement
	 * @param deadline The date and time of the deadline
	 */
	public Deadline(String requirement, Subject subject, LocalDateTime deadline) {
		this.requirement = requirement;
		this.subject = subject;
		this.deadline = deadline;
		deadlines.add(this);
	}

	/**
	 * Retrieves the deadline of the requirement
	 * @return a LocalDateTime object representing the date and time of the requirement's deadline
	 */
	public LocalDateTime getDeadline() {
		return deadline;
	}

	/**
	 * Sets the deadline to a new date and time
	 * @param deadline a LocalDateTime object representing the new date and time of the deadline
	 */
	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	/**
	 * Returns the name of the upcoming due requirement
	 * @return the name of the upcoming due requirement
	 */
	public String getRequirement() {
		return requirement;
	}

	/**
	 * Sets the name of the upcoming due requirement
	 * @param requirement the new name of the requirement
	 */
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	/**
	 * Returns the Subject associated with the requirement
	 * @return the Subject associated with the requirement, or null if no Subject was defined
	 */
	public Subject getSubject() {
		return subject;
	}

	/**
	 * Sets the Subject to be associated with the requirement
	 * @param subject the Subject to be associated with the requirement
	 */
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	/**
	 * Returns the DeadlineList containing this Deadline
	 * @return the DeadlineList containing this Deadline
	 */
	public DeadlineList getDeadlineList() {
		return deadlineList;
	}

	/**
	 * Sets the DeadlineList containing this Deadline
	 * @param deadlineList the new DeadlineList that will contain this Deadline
	 */
	public void setDeadlineList(DeadlineList deadlineList) {
		this.deadlineList = deadlineList;
	}

	/**
	 * Returns an ArrayList of all created Deadlines
	 * @return an ArrayList containing all created Deadlines
	 */
	public static ArrayList<Deadline> getDeadlines() {
		return deadlines;
	}

	/**
	 * Sets the ArrayList of all created Deadlines to another ArrayList containing Deadlines
	 * @param deadlines the new ArrayList of Deadlines
	 */
	public static void setDeadlines(ArrayList<Deadline> deadlines) {
		Deadline.deadlines = deadlines;
	}

	/**
	 * Adds this Deadline to the inputted DeadlineList
	 * @param deadlineList the DeadlineList to which this Deadline will be added
	 */
	public void addToDeadlineList(DeadlineList deadlineList) {
		ArrayList<Deadline> dl = deadlineList.getDeadlines();
		dl.add(this);
		deadlineList.setDeadlines(dl);
	}

	/**
	 * Removes this Deadline from the inputted DeadlineList
	 * @param deadlineList the DeadlineList from which this Deadline will be removed
	 */
	public void removeFromDeadlineList(DeadlineList deadlineList) {
		if (!deadlineList.getDeadlines().contains(this)) return; 
		ArrayList<Deadline> dl = deadlineList.getDeadlines();
		dl.remove(this);
		deadlineList.setDeadlines(dl);
	}
}