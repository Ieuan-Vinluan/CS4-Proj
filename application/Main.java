package application;
	
import application.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.time.LocalDateTime;
import java.util.ArrayList;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			// test users
			User u1 = new User("Yuen", "10", "pw1");
			User u2 = new User("Yuna", "9", "pw2");
			User u3 = new User("Yoowee", "10", "pw3");

			// test subjects
			Subject cs = new Subject("CS", "CompSci 4.png");
			Subject bio = new Subject("Biology", "Biology 2.png");
			Subject chem = new Subject("Chemistry", "Chemistry 2.png");
			Subject health = new Subject("Health", "Health 4.png");
			Subject eng = new Subject("English", "English 4.png");
			Subject fil = new Subject("Filipino", "Filipino 4.png");

			// test lgs
			LearningGuide firstLG = new LearningGuide(
					"Eng 4 - Sonnets",
					eng,
					"Sonnets usually have 14 lines and an iambic pentameter. English sonnets are composed of 3 quatrains and 1 couplet, with a rhyme scheme of ABAB CDCD EFEF GG, while Petrarchan sonnets are composed of 1 octave and 1 sestet, with a rhyme scheme of ABBA ABBA CDC DCD."
			);

			LearningGuide secondLG = new LearningGuide(
					"Chem 2 - Equilibrium Constant",
					chem,
					"The equilibrium constant of a reaction is its reaction quotient at equilibrium. Note that only gaseous and aqueous substances determine these values. If a reaction is multiplied by some factor n, then the new equilibrium constant is the previous equilibrium constant raised to the power of n."
			);

			LearningGuide thirdLG = new LearningGuide(
					"Biology 2 - Mendelian Inheritance",
					bio,
					"Mendelian Inheritance is completely dominant. That is, only one dominant allele is required for the trait to appear in an organism, but two recessive alleles are required for a trait to not appear in an organism."
			);

			LearningGuide fourthLG = new LearningGuide(
					"Health 4 - Quackery",
					health,
					"Quackery is faking one's expertise in a certain subject to entice people to purchase a certain product. An example is \"doctors\"' selling a supplement that can cure all diseases. It is thus important to be knowledgeable and careful when reading information on the internet."
			);

			LearningGuide fifthLG = new LearningGuide(
					"CS 4 - JavaFX",
					cs,
					"JavaFX is a library that can be utilized to create different GUIs. It utilizes the Model-View-Controller design pattern to create the application. In this case, the \"view\" is the .fxml file that can be created with SceneBuilder, the \"controller\" is the controller class that is created and linked to the fxml file and the model classes, and the \"model\" is whatever classes the user has already created."
			);

			// test notes
			Note firstNote = new Note(
					"Sorting algorithms",
					"Quicksort, Bubble sort, Merge sort, Insertion sort",
					cs
			);
			Note secondNote = new Note(
					"Equilibrium Constant",
					"Product of concentrations of gaseous or aqueous products at equilibrium / Product of concentrations of gaseous or aqueous reactants at equilibrium",
					chem
			);
			Note thirdNote = new Note(
					"Acids and Bases",
					"Acids give H+, bases accept H+",
					chem
			);
			Note fourthNote = new Note(
					"Ratios for M. Inheritance",
					"1 DD : 2 Dd : 1 dd --> 3 have : 1 doesn't have",
					bio
			);
			Note fifthNote = new Note(
				"Kyle Dulay Triangle Problem",
				"HC = 52/3, MC = 26/3, PC = 169/18, BP = 209/18, BQ (from Law of Cosines) = 1045/117, AQ = 476/117. After some trig, AX = 119/54?",
				null
			);

			// test quizzes
			Quiz firstQuiz = new Quiz("Chem Q3-FA1", chem, 3);
			Quiz secondQuiz = new Quiz("Health Q3-AA1", health, 1);
			Quiz thirdQuiz = new Quiz("Bio Q3-FA1", bio, 1);

			// test notes
			Question chemFA1_one = new Question(firstQuiz, "T/F: Ice is less dense than water.", "True");
			Question chemFA1_two = new Question(firstQuiz, "Symbol for the reaction quotient", "Q");
			Question chemFA1_three = new Question(firstQuiz, "Symbol for the equilibrium constant", "K");
			Question healthAA1_one = new Question(secondQuiz, "Deception to sell products?", "Quackery");
			Question bioFA1_one = new Question(thirdQuiz, "____ synthesis", "Dehydration");

			// test playlists
			Playlist firstPlaylist = new Playlist("Favorite Songs!");
			Playlist secondPlaylist = new Playlist("Flopped");

			// test songs
			Song firstSong = new Song("Foreverland", "LilyPichu", "20 March 2023", firstPlaylist, "foreverland-lilypichu.mp3");
			/*
			----------------------- Credit -----------------------
			Song: foreverland
			Artist: lilypichu
			Link: https://www.youtube.com/watch?v=A2zepLiuEJU
			------------------------------------------------------
			 */

			// test deadline list
			DeadlineList deadlineList = new DeadlineList("Important!");

			// test deadlines
			Deadline firstDeadline = new Deadline("Chemistry FA1", chem, deadlineList, LocalDateTime.of(2023, 3, 24, 12, 0));
			Deadline secondDeadline = new Deadline("CS Milestone Two", cs, deadlineList, LocalDateTime.of(2023, 3, 21, 23, 0));
			Deadline thirdDeadline = new Deadline("Bio AA3", bio, deadlineList, LocalDateTime.of(2023, 3, 23, 23, 0));
			Deadline fourthDeadline = new Deadline("English Town Hall", eng, deadlineList, LocalDateTime.of(2023, 3, 28, 23, 0));

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
