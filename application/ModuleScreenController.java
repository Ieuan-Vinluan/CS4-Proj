package application;

import application.model.LearningGuide;
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

import java.io.IOException;
import java.util.ArrayList;

public class ModuleScreenController {

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Label mod1;

    @FXML
    private ImageView mod1image;

    @FXML
    private Label mod2;

    @FXML
    private ImageView mod2image;

    @FXML
    private Label mod3;

    @FXML
    private ImageView mod3image;

    @FXML
    private Label mod4;

    @FXML
    private ImageView mod4image;

    @FXML
    private Label mod5;

    @FXML
    private ImageView mod5image;

    @FXML
    private Label mod6;

    @FXML
    private ImageView mod6image;

    @FXML
    private TextArea search;

    @FXML
    private Button searchBtn;

    @FXML
    private Button subject;

    @FXML
    private Button playlists;

    @FXML
    private Button quizzes;

    private ArrayList<Label> msLabels = new ArrayList<>();
    private  ArrayList<ImageView> msImages = new ArrayList<>();

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
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
        sc.initialize();
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) {
    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
        qc.initialize();
    }

    @FXML
    void openModule(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        if (id.contains("1")) {
            openSelectedModule(iv, 0);
        } else if (id.contains("2")) {
            openSelectedModule(iv, 1);
        } else if (id.contains("3")) {
            openSelectedModule(iv, 2);
        } else if (id.contains("4")) {
            openSelectedModule(iv, 3);
        } else if (id.contains("5")) {
            openSelectedModule(iv, 4);
        } else if (id.contains("6")) {
            openSelectedModule(iv, 5);
        }
    }

    @FXML
    void searchSubj(ActionEvent event) {

    }

    @FXML
    void initialize() {
        msLabels.add(mod1);
        msLabels.add(mod2);
        msLabels.add(mod3);
        msLabels.add(mod4);
        msLabels.add(mod5);
        msLabels.add(mod6);

        msImages.add(mod1image);
        msImages.add(mod2image);
        msImages.add(mod3image);
        msImages.add(mod4image);
        msImages.add(mod5image);
        msImages.add(mod6image);
        if (LearningGuide.getLearningGuides().size() >= 6) {
            for (int i = 0; i < 6; i += 1) {
                msLabels.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
                msImages.get(i).setImage(new Image("application/images/" + LearningGuide.getLearningGuides().get(i).getSubject().getImageFilename()));
            }
        } else {
            for (int i = 0; i < 6; i += 1) {
                if (i > LearningGuide.getLearningGuides().size() - 1) {
                    msLabels.get(i).setCursor(Cursor.DEFAULT);
                    msLabels.get(i).setOpacity(0);
                    msImages.get(i).setCursor(Cursor.DEFAULT);
                    msImages.get(i).setOpacity(0);
                } else {
                    msLabels.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
                    msImages.get(i).setImage(new Image("application/images/" + LearningGuide.getLearningGuides().get(i).getSubject().getImageFilename()));
                }
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

    private void openSelectedModule(Node event, int index) throws IOException {
        ModuleController mc = switchScene(event, "/application/module.fxml").getController();
        if (LearningGuide.getLearningGuides().size() >= index + 1) {
            mc.setLgContentText(LearningGuide.getLearningGuides().get(index).getContent());
            mc.setPathText("Home > " + LearningGuide.getLearningGuides().get(index).getSubject().getSubjectName() + " > " + LearningGuide.getLearningGuides().get(index).getTitle());
            mc.setLGTitleText(LearningGuide.getLearningGuides().get(index).getTitle());
        }
    }
}
