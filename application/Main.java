package application;
	
import application.model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// test users
			User u1 = new User("Yuen", "10", "cats");
			User u2 = new User("Yuna", "9", "choo");
			User u3 = new User("Yoowee", "10", "yuu");
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/homescreen.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
