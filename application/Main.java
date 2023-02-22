package application;
	
import application.model.LearningGuide;
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

			// test lgs
			LearningGuide firstLG = new LearningGuide(
					"Fil 4 - Ang Katipunan",
					Subject.getSubjects().get(4),
					"Ang Katipunan ay ang grupong lumaban sa mga Espanyol noong 1896 para makamit ang kalayaan ng Pilipinas mula sa Espanya. Ito ay itinatag nina Deodato Arellano, Andrés Bonifacio, Valentin Diaz, Ladislao Diwa, José Dizon, at Teodoro Plata noong 1892."
			);

			LearningGuide secondLG = new LearningGuide(
					"Degrees and Radians",
					Subject.getSubjects().get(1),
					"Consider a circle with radius r. A radian is defined as the measure of the angle that intercepts an arc of the circle with length r. Given this, (2pi * r) * (1 radian / 360) = r. Thus, solving for 1 radian, 1 radian = (180 / pi) degrees. This is the conversion factor that can be used in dimensional analysis.\n\nExample 1: Convert 40 degrees into radians.\n\nSolution: 40 degrees * (pi rad / 180 degrees) = (2pi/9) rad.\n\nThus, 40 degrees is equivalent to (2pi/9) radians."
			);

			LearningGuide thirdLG = new LearningGuide(
					"Rights",
					Subject.getSubjects().get(5),
					"Hi, I'm Saul Goodman. Did you know that you have rights? The constitution says you do! And so do I.\n" +
							"\n" +
							"Conscience gets expensive, doesn't it?\n" +
							"\n" +
							"For a substantial fee, and I do mean substantial, you and your loved ones can vanish. Untraceable.\n" +
							"\n" +
							"I want it in a money order and make it out to Ice Station Zebra Associates. That's my loan out. It's totally legit … it's done just for tax purposes. After that we can discuss Visa or Mastercard, but definitely not American Express, so don't even ask, all right?"
			);

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
