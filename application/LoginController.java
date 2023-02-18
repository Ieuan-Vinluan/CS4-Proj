package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    void login(ActionEvent event) throws IOException {
    	String un = username.getText();
    	String pw = password.getText();
    	
    	if (un.equals("") || pw.equals("")) {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.setTitle("Input is empty!");
    		alert.setContentText(">:C");
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
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Wrong password!");
				alert.setContentText("The inputted password was wrong. Please try again.");
				alert.showAndWait();
				break;
    		}
    		
    		// the user name and the password are correct
    		currentUser.setHasAccess(true);
    		System.out.println(currentUser.getUsername() + " now has access.");
    	}
    	if (!userFound) System.out.println("User \"" + un + "\" doesn't exist.");

		// if user successfully logged in, they can access the rest of the app
		if (currentUser.isHasAccess()) {
			Node node = (Node) event.getSource();
			Scene currentScene = node.getScene();
			Stage currentStage = (Stage) currentScene.getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/subject.fxml"));
			Parent root = loader.load();
			Scene newScene = new Scene(root);

			currentStage.hide();
			currentStage.setScene(newScene);
			currentStage.show();


			SubjectController sc = loader.getController();
			System.out.println("User " + currentUser.getUsername() + " has logged in.");
			sc.initialize();

		}
    }

    @FXML
    void initialize() {
    	loginBtn.setDefaultButton(true); // for user convenience
    }
    
    public User getCurrentUser() {
		return currentUser;
	}
    
    public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
