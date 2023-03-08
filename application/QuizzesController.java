package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Quiz;
import application.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class QuizzesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Label quiz1;

    @FXML
    private ImageView quiz1image;

    @FXML
    private Label quiz2;

    @FXML
    private ImageView quiz2image;

    @FXML
    private Label quiz3;

    @FXML
    private ImageView quiz3image;

    @FXML
    private Label quiz4;

    @FXML
    private ImageView quiz4image;

    @FXML
    private Label quiz5;

    @FXML
    private ImageView quiz5image;

    @FXML
    private Label quiz6;

    @FXML
    private ImageView quiz6image;

    @FXML
    private Button quizzes;

    @FXML
    private TextArea search;

    @FXML
    private Button searchBtn;

    @FXML
    private Button subject;

    private ArrayList<Label> labels = new ArrayList<>();

    private ArrayList<ImageView> ivs = new ArrayList<>();

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToQuiz(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        System.out.println("Clicked from " + id);
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void goToPlaylist(ActionEvent actionEvent) {

    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
    }

    @FXML
    void searchQuiz(ActionEvent event) {
        // todo
    }

    @FXML
    void initialize() {
        labels.add(quiz1);
        labels.add(quiz2);
        labels.add(quiz3);
        labels.add(quiz4);
        labels.add(quiz5);
        labels.add(quiz6);
        ivs.add(quiz1image);
        ivs.add(quiz2image);
        ivs.add(quiz3image);
        ivs.add(quiz4image);
        ivs.add(quiz5image);
        ivs.add(quiz6image);

        int size = Quiz.getQuizzes().size();
        for (int i = 0; i < 6; i += 1) {
            if (i > size - 1) {
                labels.get(i).setOpacity(0);
                ivs.get(i).setOpacity(0);
                ivs.get(i).setCursor(Cursor.DEFAULT);
            } else {
                labels.get(i).setText(Quiz.getQuizzes().get(i).getQuizID());
                ivs.get(i).setImage(new Image("application/images/" + Quiz.getQuizzes().get(i).getSubject().getImageFilename()));
            }
        }
    }

    private FXMLLoader switchScene(Node node, String path) throws IOException {
        // getting current window
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        // loading new window
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        currentStage.hide();
        currentStage.setScene(newScene);
        currentStage.show();

        return loader;
    }

}
