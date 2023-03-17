package application;

import application.model.LearningGuide;
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
    private Label username;

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
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) {
    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
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
        String searched = search.getText();
        boolean found = false;
        for (LearningGuide lg : LearningGuide.getLearningGuides()) {
            if (lg.getTitle().equalsIgnoreCase(searched)) {
                found = true;
                int index = LearningGuide.getLearningGuides().indexOf(lg);
                if (index == 0) return; // it's already there
                LearningGuide temp = LearningGuide.getLearningGuides().get(0);
                LearningGuide.getLearningGuides().set(0, lg);
                LearningGuide.getLearningGuides().set(index, temp);
                if (index > 5) return; // no need to switch their places if one does not appear on screen
                mod1.setText(lg.getTitle());
                mod1image.setImage(new Image("application/images/" + lg.getSubject().getImageFilename()));
                switch(index) {
                    case 1:
                        mod2.setText(temp.getTitle());
                        mod2image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 2:
                        mod3.setText(temp.getTitle());
                        mod3image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 3:
                        mod4.setText(temp.getTitle());
                        mod4image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 4:
                        mod5.setText(temp.getTitle());
                        mod5image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 5:
                        mod6.setText(temp.getTitle());
                        mod6image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                }
            }
        }
        if (!found) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Doesn't exist :<");
            alert.setContentText("The inputted LG does not exist :\"((");
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        LoginController.setProfileText(username);
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
                    msLabels.get(i).setVisible(false);
                    msImages.get(i).setVisible(false);
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
