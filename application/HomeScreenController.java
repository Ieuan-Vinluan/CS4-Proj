package application;

import application.model.LearningGuide;
import application.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomeScreenController {

    @FXML
    private Label lg1;

    @FXML
    private Label lg2;

    @FXML
    private Label lg3;

    @FXML
    private Label lg4;

    @FXML
    private Label lg5;

    @FXML
    private Button home;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button subject;

    private ArrayList<Label> lgs = new ArrayList<>();

    // test lgs
    private LearningGuide firstLG;
    private LearningGuide secondLG;
    private LearningGuide thirdLG;
    private LearningGuide fourthLG;
    private LearningGuide fifthLG;
    private LearningGuide sixthLG;

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
    void openLG1(MouseEvent event) throws IOException {
        openLearningGuide((Node) event.getSource(), 0);
    }

    @FXML
    void openLG2(MouseEvent event) throws IOException {
        openLearningGuide((Node) event.getSource(), 1);
    }

    @FXML
    void openLG3(MouseEvent event) throws IOException {
        openLearningGuide((Node) event.getSource(), 2);
    }

    @FXML
    void openLG4(MouseEvent event) throws IOException {
        openLearningGuide((Node) event.getSource(), 3);
    }

    @FXML
    void openLG5(MouseEvent event) throws IOException {
        openLearningGuide((Node) event.getSource(), 4);
    }

    @FXML
    void initialize() {
        int counter = 0;
        for (LearningGuide lg : LearningGuide.getLearningGuides()) {
            switch(counter) {
                case 0:
                    firstLG = LearningGuide.getLearningGuides().get(0);
                    break;
                case 1:
                    secondLG = LearningGuide.getLearningGuides().get(1);
                    break;
                case 2:
                    thirdLG = LearningGuide.getLearningGuides().get(2);
                    break;
                case 3:
                    fourthLG = LearningGuide.getLearningGuides().get(3);
                    break;
                case 4:
                    fifthLG = LearningGuide.getLearningGuides().get(4);
                    break;
                case 5:
                    sixthLG = LearningGuide.getLearningGuides().get(5);
                    break;
                default:
                    System.out.println("Error!");
            }
            counter += 1;
        }
        lgs.add(lg1);
        lgs.add(lg2);
        lgs.add(lg3);
        lgs.add(lg4);
        lgs.add(lg5);

        if (LearningGuide.getLearningGuides().size() < 5) {
            int size = LearningGuide.getLearningGuides().size();
            for (int i = 0; i < 5; i += 1) {
                if (i >= size) {
                    lgs.get(i).setOpacity(0); // hide
                } else {
                    lgs.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
                }
            }
        } else {
            for (int i = 0; i < 5; i += 1) {
                lgs.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
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

    private void openLearningGuide(Node event, int index) throws IOException {
        ModuleController mc = switchScene(event, "/application/module.fxml").getController();
        if (LearningGuide.getLearningGuides().size() >= index + 1) {
            mc.setPathText("Home > " + LearningGuide.getLearningGuides().get(index).getSubject().getSubjectName() + " > " + LearningGuide.getLearningGuides().get(index).getTitle());
            mc.setLGTitleText(LearningGuide.getLearningGuides().get(index).getTitle());
            mc.setLgContentText(LearningGuide.getLearningGuides().get(index).getContent());
        }
    }

}
