package application;

import application.model.LearningGuide;
import application.model.Quiz;
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

public class SubjectScreenController {

    @FXML
    private Label username;

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
    private Label quiz1;

    @FXML
    private ImageView quiz1image;

    @FXML
    private Label quiz2;

    @FXML
    private ImageView quiz2image;

    @FXML
    private Label quiz3;

    @FXML
    private ImageView quiz3image;

    @FXML
    private Label quiz4;

    @FXML
    private ImageView quiz4image;

    @FXML
    private Label quiz5;

    @FXML
    private ImageView quiz5image;

    private ArrayList<Label> labels = new ArrayList<>();
    private ArrayList<ImageView> ivs = new ArrayList<>();
    
    private ArrayList<LearningGuide> lgs = new ArrayList<>();
    private ArrayList<Quiz> subjectQuizzes = new ArrayList<>();

    @FXML
    void goToHome(ActionEvent actionEvent) throws IOException {
        HomeScreenController hsc = switchScene((Node) actionEvent.getSource(), "/application/homescreen.fxml").getController();
        System.out.println("Went back to home!");
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
    void goToPlaylists(ActionEvent actionEvent) throws IOException {

    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void initialize() {
        LoginController.setProfileText(username);
    }
    
    @FXML
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
    
    @FXML
    private void openLearningGuide(Node event, int index) throws IOException {
        ModuleController mc = switchScene(event, "/application/module.fxml").getController();
        if (LearningGuide.getLearningGuides().size() >= index + 1) {
            mc.setLgContentText(LearningGuide.getLearningGuides().get(index).getContent());
            mc.setPathText("Home > " + LearningGuide.getLearningGuides().get(index).getSubject().getSubjectName() + " > " + LearningGuide.getLearningGuides().get(index).getTitle());
            mc.setLGTitleText(LearningGuide.getLearningGuides().get(index).getTitle());
        }
    }
    
    @FXML
    void openModule(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
//        if (id.contains("1")) {
//            openSelectedModule(iv, 0);
//        } else if (id.contains("2")) {
//            openSelectedModule(iv, 1);
//        } else if (id.contains("3")) {
//            openSelectedModule(iv, 2);
//        } else if (id.contains("4")) {
//            openSelectedModule(iv, 3);
//        } else if (id.contains("5")) {
//            openSelectedModule(iv, 4);
//        }
    }
    
    @FXML
    private void openQuiz(Node event, int index) throws IOException {
        QuizController qc = switchScene(event, "/application/quiz.fxml").getController();
        Quiz selectedQuiz = Quiz.getQuizzes().get(index);
        if (Quiz.getQuizzes().size() >= index + 1) {
            qc.setQuestions(selectedQuiz.getQuestions());
            for (int i = 0; i < selectedQuiz.getQuestions().size(); i += 1) {
                qc.getAnswers().add("");
            }
            try {
                for (int i = 0; i < 2; i += 1) {
                    try {
                        qc.setQuestionText(i, qc.getQuestions().get(i).getQuestion());
                    } catch (IndexOutOfBoundsException e) {
                        qc.getAnchorpanes().get(i).setVisible(false);
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
            qc.getQuizSubject().setText("Subject: " + selectedQuiz.getSubject().getSubjectName());
            qc.getQuizID().setText("ID: " + selectedQuiz.getQuizID());
        }
    }
    
    @FXML
    void goToQuiz(MouseEvent event) throws IOException {
        Label clicked = (Label) event.getSource();
        String id = clicked.getId();
        if (id.contains("1")) {
            openQuiz(clicked, 0);
        } else if (id.contains("2")) {
            openQuiz(clicked, 1);
        } else if (id.contains("3")) {
            openQuiz(clicked, 2);
        } else if (id.contains("4")) {
            openQuiz(clicked, 3);
        } else if (id.contains("5")) {
            openQuiz(clicked, 4);
        }
    }

}
