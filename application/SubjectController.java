package application;

import application.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

public class SubjectController {

    @FXML
    private Button modules;
    @FXML
    private Button home;
    @FXML
    private Button subject;

    @FXML
    private Button quizzes;
    @FXML
    private Button playlists;

    @FXML
    private Label sub1;

    @FXML
    private ImageView sub1image;

    @FXML
    private Label sub2;

    @FXML
    private ImageView sub2image;

    @FXML
    private Label sub3;

    @FXML
    private ImageView sub3image;

    @FXML
    private Label sub4;

    @FXML
    private ImageView sub4image;

    @FXML
    private Label sub5;

    @FXML
    private ImageView sub5image;

    @FXML
    private Label sub6;

    @FXML
    private Label username;

    @FXML
    private ImageView sub6image;

    @FXML
    private TextArea search;

    @FXML
    private Button searchBtn;

    private ArrayList<Subject> prevAccessedSubjs = new ArrayList<>();

    private ArrayList<Label> labels = new ArrayList<>();
    private ArrayList<ImageView> ivs = new ArrayList<>();

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
            prevAccessedSubjs.set(prevAccessedSubjs.size() - 1, subject);
        }
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
    }

    @FXML
    void goToCourse(MouseEvent event) {
        System.out.println("Clicked from " + event.getPickResult().getIntersectedNode().getId()); // debug purposes
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void searchSubj(ActionEvent event) {
        String searchedSubj = search.getText();
        boolean found = false;
        for (Subject s : Subject.getSubjects()) {
            if (s.getSubjectName().equalsIgnoreCase(searchedSubj)) {
                found = true;
                int index = Subject.getSubjects().indexOf(s);
                if (index == 0) return; // it's already there
                Subject temp = Subject.getSubjects().get(0);
                Subject.getSubjects().set(0, s);
                Subject.getSubjects().set(index, temp);
                if (index > 5) return; // no need to switch their places if one does not appear on screen
                sub1.setText(s.getSubjectName());
                sub1image.setImage(new Image("application/images/" + s.getImageFilename()));
                switch(index) {
                    case 1:
                        sub2.setText(temp.getSubjectName());
                        sub2image.setImage(new Image("application/images/" + temp.getImageFilename()));
                        break;
                    case 2:
                        sub3.setText(temp.getSubjectName());
                        sub3image.setImage(new Image("application/images/" + temp.getImageFilename()));
                        break;
                    case 3:
                        sub4.setText(temp.getSubjectName());
                        sub4image.setImage(new Image("application/images/" + temp.getImageFilename()));
                        break;
                    case 4:
                        sub5.setText(temp.getSubjectName());
                        sub5image.setImage(new Image("application/images/" + temp.getImageFilename()));
                        break;
                    case 5:
                        sub6.setText(temp.getSubjectName());
                        sub6image.setImage(new Image("application/images/" + temp.getImageFilename()));
                        break;
                }
            }
        }
        if (!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Doesn't exist :<");
            alert.setContentText("The inputted subject does not exist :\"((");
            alert.showAndWait();
        }
    }

    @FXML
    void goToHome(ActionEvent actionEvent) throws IOException {
        HomeScreenController hsc = switchScene((Node) actionEvent.getSource(), "/application/homescreen.fxml").getController();
        System.out.println("Went back to home!");
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) throws IOException {

    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void initialize() {
        LoginController.setProfileText(username);
        labels.add(sub1);
        labels.add(sub2);
        labels.add(sub3);
        labels.add(sub4);
        labels.add(sub5);
        labels.add(sub6);
        ivs.add(sub1image);
        ivs.add(sub2image);
        ivs.add(sub3image);
        ivs.add(sub4image);
        ivs.add(sub5image);
        ivs.add(sub6image);

        int size = Subject.getSubjects().size();
        for (int i = 0; i < 6; i += 1) {
            if (i > size - 1) {
                labels.get(i).setOpacity(0);
                ivs.get(i).setOpacity(0);
                ivs.get(i).setCursor(Cursor.DEFAULT);
            } else {
                labels.get(i).setText(Subject.getSubjects().get(i).getSubjectName());
                ivs.get(i).setImage(new Image("application/images/" + Subject.getSubjects().get(i).getImageFilename()));
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
