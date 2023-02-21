package application;
	
import application.model.Subject;
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

			Subject cs = new Subject("CS", "computer science.png");
			Subject math = new Subject("Math", "computer science.png");
			Subject eng = new Subject("Eng", "computer science.png");
			Subject res = new Subject("Research", "computer science.png");
			Subject fil = new Subject("Filipino", "computer science.png");
			Subject ss = new Subject("SS", "computer science.png");
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/login.fxml"));
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
