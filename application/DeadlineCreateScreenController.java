package application;

import application.model.Deadline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class DeadlineCreateScreenController {

    @FXML
    private TextArea dateText;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Button playlists;

    @FXML
    private Button quizzes;

    @FXML
    private TextArea reqText;

    @FXML
    private Button subject;

    @FXML
    private Button submitBtn;

    @FXML
    private TextArea timeText;

    @FXML
    private Label username;

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModules(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) throws IOException {
        PlaylistController pc = switchScene((Node) actionEvent.getSource(), "/application/playlist.fxml").getController();
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void submitText(ActionEvent event) throws IOException {
        String requirement = reqText.getText();
        String date = dateText.getText();
        String time = timeText.getText();
        Deadline createdDeadline = new Deadline(requirement, null, LocalDateTime.parse(date + "T" + time));
        System.out.println(createdDeadline.getDeadline());
        goToHome(event);
    }

    @FXML
    void initialize() {
        System.out.println("SUCCESS");
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
