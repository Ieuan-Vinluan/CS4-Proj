package application;
	
import application.model.*;
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
			User u1 = new User("Yuen", "10", "pw1");
			User u2 = new User("Yuna", "9", "pw2");
			User u3 = new User("Yoowee", "10", "pw3");

			// test subjects
			Subject cs = new Subject("CS", "computer science - edited.png");
			Subject math = new Subject("Math", "math - edited.png");
			Subject chem = new Subject("Chemistry", "computer science - edited.png");
			Subject dm = new Subject("Discrete Math", "math - edited.png");
			Subject phys = new Subject("Physics", "physics - edited.png");
			Subject ss = new Subject("SocSci", "social science - edited.png");

			// test lgs
			LearningGuide firstLG = new LearningGuide(
					"Physics 2 - Mirrors",
					Subject.getSubjects().get(4),
					"Mirrors can be either concave or convex. Concave mirrors, also known as converging mirrors, are the only mirrors that are capable of enlarging images. On the other hand, the images formed by convex mirrors are always smaller than the original object. Both types of mirrors can be applied in many ways."
			);

			LearningGuide secondLG = new LearningGuide(
					"Math 4 - Degrees and Radians",
					Subject.getSubjects().get(1),
					"Consider a circle with radius r. A radian is defined as the measure of the angle that intercepts an arc of the circle with length r. Given this, (2pi * r) * (1 radian / 360) = r. Thus, solving for 1 radian, 1 radian = (180 / pi) degrees. This is the conversion factor that can be used in dimensional analysis.\n\nExample 1: Convert 40 degrees into radians.\n\nSolution: 40 degrees * (pi rad / 180 degrees) = (2pi/9) rad.\n\nThus, 40 degrees is equivalent to (2pi/9) radians."
			);

			LearningGuide thirdLG = new LearningGuide(
					"SocSci 4 - Rights",
					Subject.getSubjects().get(5),
					"All humans have rights. These include natural rights, which are innate or inherent; constitutional rights, which are granted by the constitution; and statutory rights, which are rights conferred by the legislative and can be sub-divided into 3: political rights, civil rights, and social and economic rights. The rights of the individual are important for the function of a democratic society."
			);

			LearningGuide fourthLG = new LearningGuide(
					"Discrete Math - Basic Formulas",
					Subject.getSubjects().get(3),
					"A group of objects, assuming all are distinct from one another, can be arranged in a row in n! ways, where n is the number of objects in the group. If one were to choose r objects from the n objects and arrange them in a row, then there would be n!/(n-r)! ways to arrange them. Meanwhile, the number of ways to simply choose r objects from the n objects is n!/(r!(n-r)!). Notice that an additional factor of 1/r! was added to get rid of the order of the objects because we do not care about the order."
			);

			LearningGuide fifthLG = new LearningGuide(
					"CS 4 - JavaFX",
					Subject.getSubjects().get(0),
					"JavaFX is a library that can be utilized to create different GUIs. It utilizes the Model-View-Controller design pattern to create the application. In this case, the \"view\" is the .fxml file that can be created with SceneBuilder, the \"controller\" is the controller class that is created and linked to the fxml file and the model classes, and the \"model\" is whatever classes the user has already created."
			);

			// test notes
			Note firstNote = new Note(
					"Important Trig Identity",
					"tanx = sinx/cosx",
					math
			);
			Note secondNote = new Note(
					"Electric Field Equation",
					"E = kq/r^2",
					math
			);
			Note thirdNote = new Note(
					"Acids and Bases",
					"Acids give H+, bases accept H+",
					chem
			);
			Note fourthNote = new Note(
					"Radian and Degree Conversion",
					"1 degree = (180 / pi) rad",
					math
			);
			Note fifthNote = new Note(
				"Kyle Dulay Triangle Problem",
				"HC = 52/3, MC = 26/3, PC = 169/18, BP = 209/18, BQ (from Law of Cosines) = 1045/117, AQ = 476/117. After some trig, AX = 119/54?",
				math
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
