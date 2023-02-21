package application;

import application.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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


import java.io.IOException;
import java.util.ArrayList;

public class SubjectController {

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
    private ImageView sub6image;

    @FXML
    private TextArea search;

    @FXML
    private Button searchBtn;

    private ArrayList<Subject> prevAccessedSubjs = new ArrayList<>();

    // test subjects
    private Subject cs = new Subject("CS", "computer science.png");
    private Subject math = new Subject("Math", "computer science.png");
    private Subject eng = new Subject("Eng", "computer science.png");
    private Subject res = new Subject("Research", "computer science.png");
    private Subject fil = new Subject("Filipino", "computer science.png");
    private Subject ss = new Subject("SS", "computer science.png");

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

        // I suggest putting the changing window thing into its own function to make the code more readable

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
    void goToCourse(MouseEvent event) {
        System.out.println("Clicked from " + event.getPickResult().getIntersectedNode().getId()); // debug purposes
    }

    @FXML
    void searchSubj(ActionEvent event) {
        String searchedSubj = search.getText();
        for (Subject s : Subject.getSubjects()) {
            if (s.getSubjectName().equalsIgnoreCase(searchedSubj)) {
                sub1.setText(s.getSubjectName());
                try {
                    sub1image.setImage(new Image("images" + s.getImageFilename())); // doesn't work fsr LMAO
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void initialize() {
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

        if (Subject.getSubjects().size() >= 6) {
            for (int i = 0; i < 6; i += 1) {
                labels.get(i).setText(Subject.getSubjects().get(i).getSubjectName());
                ivs.get(i).setImage(new Image("application/images/" + Subject.getSubjects().get(i).getImageFilename()));
            }
        }
    }
}
