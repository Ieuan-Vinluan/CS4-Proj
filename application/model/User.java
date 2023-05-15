package application.model;

import java.util.ArrayList;

/**
 * The User class represents the person who will be using the app; it is similar to an "account." It contains the user's username, grade level, password, and an ArrayList containing all Users. It also contains information that determines whether the User can access the app or not.
 *
 * @author Ieuan Vinluan
 * @version 1.0
 */
public class User {
    /**
     * The user's username
     */
    private String username;
    /**
     * The user's grade level
     */
    private String gradeLevel;
    /**
     * The user's password
     */
    private String password;
    /**
     * A boolean value indicating whether the User has access or not
     */
    private boolean hasAccess;
    /**
     * The ArrayList of all created Users
     */
    private static ArrayList<User> users = new ArrayList<>();

    /**
     * Returns the User's username
     *
     * @return the Users username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the User's username
     *
     * @param username the User's new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Retrieves the User's grade level
     *
     * @return the User's grade level
     */
    public String getGradeLevel() {
        return gradeLevel;
    }

    /**
     * Sets the User's grade level
     *
     * @param gradeLevel the User's new grade level
     */
    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    /**
     * Returns the User's password
     *
     * @return the User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the User's password
     *
     * @param password the User's new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a boolean value indicating whether the User has access or not
     *
     * @return a boolean value indicating whether the User has access or not
     */
    public boolean isHasAccess() {
        return hasAccess;
    }

    /**
     * Allows or disallows the User from accessing the app
     *
     * @param hasAccess a boolean value whether the User has access to the app or not
     */
    public void setHasAccess(boolean hasAccess) {
        this.hasAccess = hasAccess;
    }

    /**
     * Returns the ArrayList of all created Users
     *
     * @return the ArrayList of all created Users
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Sets the ArrayList containing all Users to another ArrayList containing Users
     *
     * @param users the new ArrayList that contains Users
     */
    public static void setUsers(ArrayList<User> users) {
        User.users = users;
    }

    /**
     * @param username   the User's username
     * @param gradeLevel the User's grade level
     * @param password   the User's password
     */
    public User(String username, String gradeLevel, String password) {
        this.username = username;
        this.gradeLevel = gradeLevel;
        this.password = password;
        this.setHasAccess(false);
        User.users.add(this);
    }

    /**
     * Allows the User to attempt to log into the app and, depending on if the inputted password is correct, determines if the User can access the app
     *
     * @param password the inputted password
     */
    public void login(String password) {
        if (password.equals(this.password)) {
            this.setHasAccess(true);
        } else {

        }
    }
}
