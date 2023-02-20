package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Subject;
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

    private ArrayList<Subject> prevAccessedSubjs = new ArrayList<>();

    public ArrayList<Subject> getPrevAccessedSubjs() {
        return prevAccessedSubjs;
    }

    public void setPrevAccessedSubjs(ArrayList<Subject> prevAccessedSubjs) {
        this.prevAccessedSubjs = prevAccessedSubjs;
    }

    public void setLatestPrevSubj(Subject subject) {
        if (prevAccessedSubjs.size() < 6) {
            
            // if not enough subjects have been accessed, add to the ArrayList
            prevAccessedSubjs.add(subject);
        } else {

            // shift everything to the left by one index
            for (int i = 0; i < prevAccessedSubjs.size() - 1; i += 1) {
                prevAccessedSubjs.set(i, prevAccessedSubjs.get(i + 1));
            }

            // add new subject
            prevAccessedSubjs.set(prevAccessedSubjs.size(), subject);
        }
    }

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
