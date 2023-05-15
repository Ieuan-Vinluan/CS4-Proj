package application.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The DeadlineList class represents a container for Deadlines. It has a name and an ArrayList containing Deadline objects.
 *
 * @author Ieuan Vinluan
 * @version 1.0
 */
public class DeadlineList {

    /**
     * The name of the DeadlineList
     */
    private String deadlineListName;
    /**
     * The ArrayList containing the Deadlines that this DeadlineList will contain
     */
    private ArrayList<Deadline> deadlines = new ArrayList<>();

    /**
     * @param deadlineListName The name of the DeadlineList
     */
    public DeadlineList(String deadlineListName) {
        this.deadlineListName = deadlineListName;
    }

    /**
     * Returns the name of the DeadlineList
     *
     * @return the name of the DeadlineList
     */
    public String getDeadlineListName() {
        return deadlineListName;
    }

    /**
     * Sets the name of the DeadlineList
     *
     * @param deadlineListName the new name of the DeadlineList
     */
    public void setDeadlineListName(String deadlineListName) {
        this.deadlineListName = deadlineListName;
    }

    /**
     * Retrieves the ArrayList of contained Deadlines
     *
     * @return the ArrayList of contained Deadlines
     */
    public ArrayList<Deadline> getDeadlines() {
        return deadlines;
    }

    /**
     * Sets the ArrayList of contained Deadlines to a new ArrayList that contains Deadlines
     *
     * @param deadlines the new ArrayList that contains Deadlines
     */
    public void setDeadlines(ArrayList<Deadline> deadlines) {
        this.deadlines = deadlines;
    }

    /**
     * Adds the Deadlines of another DeadlineList to this DeadlineList
     *
     * @param deadlineList the DeadlineList whose Deadlines will be added
     */
    public void compoundWithDeadlineList(DeadlineList deadlineList) {
        ArrayList<Deadline> newList = deadlineList.getDeadlines();
        newList.addAll(deadlines);
        deadlineList.setDeadlines(newList);
    }

    /**
     * Sets the date and time of all contained Deadlines to a new date and time
     *
     * @param newDL
     */
    public void changeContentsDeadlines(LocalDateTime newDL) {
        for (Deadline d : deadlines) {
            d.setDeadline(newDL);
        }
    }

    /**
     * Removes this DeadlineList's contents from the contents of another DeadlineList
     *
     * @param deadlineList the other DeadlineList from which the contents of this DeadlineList will be removed
     */
    public void removeFromDeadlineList(DeadlineList deadlineList) {
        ArrayList<Deadline> newList = deadlineList.getDeadlines();
        newList.removeAll(deadlines);
        deadlineList.setDeadlines(newList);
    }

    /**
     * Sorts the contained Deadlines by date and time using Quick Sort
     *
     * @param deadlines the ArrayList of Deadlines to be sorted
     * @param low       the starting index
     * @param high      the ending index
     * @param pivot     the element that will be used as basis for the division of the elements in sorting
     */
    public static void sortDeadlineList(ArrayList<Deadline> deadlines, int low, int high, Deadline pivot) {

        // implementation of quick sort for deadlines

        if (low >= high) return;

        int left = low, right = high;

        while (left < right) {
            while (left < right && deadlines.get(left).getDeadline().isBefore(pivot.getDeadline())) {
                if (deadlines.get(left).equals(deadlines.get(right))) {
                    left += 1;
                    break;
                }
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

    /**
     * Swaps the positions of two Deadlines in an ArrayList
     *
     * @param deadlines the ArrayList containing Deadlines
     * @param first     the index of the first element
     * @param second    the index of the second element
     */
    private static void swap(ArrayList<Deadline> deadlines, int first, int second) {
        Deadline temp = deadlines.get(first);
        deadlines.set(first, deadlines.get(second));
        deadlines.set(second, temp);
    }
}
