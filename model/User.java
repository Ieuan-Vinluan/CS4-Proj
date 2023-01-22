package model;
public class User {
	
	private String username;
	private String gradeLevel;
	private String password;
	private boolean hasAccess;
	
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
	
	public User(String username, String gradeLevel, String password) {
		this.username = username;
		this.gradeLevel = gradeLevel;
		this.password = password;
		this.hasAccess = false;
	}
	
	public void login(String password) { // throws WrongPasswordException
		if (password.equals(this.password)) {
			this.hasAccess = true;
		} else {
			// throw WrongPasswordException
		}
	}
}
