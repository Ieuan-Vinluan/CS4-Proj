package application;

import java.util.ArrayList;

public class User {
	
	private String username;
	private String gradeLevel;
	private String password;
	private boolean hasAccess;
	private static ArrayList<User> users = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getGradeLevel() {
		return gradeLevel;
	}
	
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isHasAccess() {
		return hasAccess;
	}

	public void setHasAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}
	
	public static ArrayList<User> getUsers() {
		return users;
	}
	
	public static void setUsers(ArrayList<User> users) {
		User.users = users;
	}
	
	public User(String username, String gradeLevel, String password) {
		this.username = username;
		this.gradeLevel = gradeLevel;
		this.password = password;
		this.setHasAccess(false);
		this.users.add(this);
	}
	
	public void login(String password) { // throws WrongPasswordException
		if (password.equals(this.password)) {
			this.setHasAccess(true);
		} else {
			// throw WrongPasswordException
		}
	}
}
