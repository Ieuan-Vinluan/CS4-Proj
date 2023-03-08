package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ModuleController {

    @FXML
    private Button home;

    @FXML
    private Label lgContent;

    @FXML
    private Label lgTitle;

    @FXML
    private Label path;

    @FXML
    private Button subject;

    @FXML
    private Button modules;

    @FXML
    private Button quizzes;

    @FXML
    private Button playlists;

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
        sc.initialize();
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
        System.out.println("Went back to home!");
        hsc.initialize();
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
        msc.initialize();
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) throws IOException {

    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
        qc.initialize();
    }

    @FXML
    void initialize() {

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

    public void setPathText(String text) {
        path.setText(text);
    }

    public void setLGTitleText(String text) {
        lgTitle.setText(text);
    }

    public void setLgContentText(String text) {
        lgContent.setText(text);
    }
}
