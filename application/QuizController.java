package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class QuizController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private AnchorPane box1;

    @FXML
    private AnchorPane box2;

    @FXML
    private Button finish;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Button nextBtn;

    @FXML
    private Button playlists;

    @FXML
    private Label question1;

    @FXML
    private TextArea question1text;

    @FXML
    private Label question2;

    @FXML
    private TextArea question2text;

    @FXML
    private Label quizID;

    @FXML
    private Label quizSubject;

    @FXML
    private Button quizzes;

    @FXML
    private Button subject;

    @FXML
    private Label username;

    private ArrayList<Question> questions = new ArrayList<>();

    private ArrayList<AnchorPane> anchorpanes = new ArrayList<>();

    @FXML
    void finish(ActionEvent event) {

    }

    @FXML
    void goBack(ActionEvent event) {

    }

    @FXML
    void goNext(ActionEvent event) {

    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToPlaylists(ActionEvent event) {

    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
    }

    @FXML
    void initialize() {
        anchorpanes.add(box1);
        anchorpanes.add(box2);
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

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void setQuestionText(int index, String text) {
        if (index == 0) {
            question1.setText(text);
        } else if (index == 1) {
            question2.setText(text);
        } else {
            System.out.println("Error!");
        }
    }

    public ArrayList<AnchorPane> getAnchorpanes() {
        return anchorpanes;
    }

    public TextArea getQuestion2text() {
        return question2text;
    }
}
