package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SubjectController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button subject;

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        // getting current window
        Node node = (Node) event.getSource();
        Scene currentScene = node.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();

        // loading new window
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/subject.fxml"));
        Parent root = loader.load();
        Scene newScene = new Scene(root);

        currentStage.hide();
        currentStage.setScene(newScene);
        currentStage.show();

        SubjectController sc = loader.getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
    }

    @FXML
    void initialize() {

    }

}
