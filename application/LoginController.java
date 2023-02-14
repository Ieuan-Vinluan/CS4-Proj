package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
	
	private User currentUser;
	
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    @FXML
    void login(ActionEvent event) {
    	String un = username.getText();
    	String pw = password.getText();
    	
    	if (un.equals("") || pw.equals("")) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Input is empty!");
    		alert.setContentText("You are bad >:C");
    		alert.showAndWait();
    		return;
    	}
    	
    	boolean userFound = false;
    	for (User user : User.getUsers()) {
    		
    		// if it is not the user, then skip
    		if (!user.getUsername().equals(un)) {
    			continue;
    		}
    		userFound = true;
    		currentUser = user;
    		
    		// if the password is wrong, then do not give access
    		if (!currentUser.getPassword().equals(pw)) {
    			System.out.println("Wrong password. " + currentUser.getUsername() + " does not have access.");
    			break;
    		}
    		
    		// the user name and the password are correct
    		currentUser.setHasAccess(true);
    		System.out.println(currentUser.getUsername() + " now has access.");
    	}
    	if (!userFound) System.out.println("User \"" + un + "\" doesn't exist.");
    }

    @FXML
    void initialize() {
    	loginBtn.setDefaultButton(true);
    }
    
    public User getCurrentUser() {
		return currentUser;
	}
    
    public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
