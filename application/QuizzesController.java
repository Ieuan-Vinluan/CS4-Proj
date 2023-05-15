package application;

import application.model.Quiz;
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
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuizzesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button home;

    @FXML
    private Button modules;

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

    @FXML
    private Label quiz6;

    @FXML
    private Label username;

    @FXML
    private ImageView quiz6image;

    @FXML
    private Button quizzes;

    @FXML
    private TextArea search;

    @FXML
    private Button searchBtn;

    @FXML
    private Button subject;

    private ArrayList<Label> labels = new ArrayList<>();

    private ArrayList<ImageView> ivs = new ArrayList<>();

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToQuiz(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        System.out.println("Clicked from " + id);
        if (id.contains("1")) {
            openQuiz(iv, 0);
        } else if (id.contains("2")) {
            openQuiz(iv, 1);
        } else if (id.contains("3")) {
            openQuiz(iv, 2);
        } else if (id.contains("4")) {
            openQuiz(iv, 3);
        } else if (id.contains("5")) {
            openQuiz(iv, 4);
        } else {
            openQuiz(iv, 5);
        }
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void goToPlaylist(ActionEvent actionEvent) throws IOException {
        PlaylistController pc = switchScene((Node) actionEvent.getSource(), "/application/playlist.fxml").getController();
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
    }

    @FXML
    void searchQuiz(ActionEvent event) {
        String searchedQuiz = search.getText();
        boolean found = false;
        for (Quiz q : Quiz.getQuizzes()) {
            if (q.getQuizID().equalsIgnoreCase(searchedQuiz)) {
                found = true;
                int index = Quiz.getQuizzes().indexOf(q);
                if (index == 0) return; // it's already there
                Quiz temp = Quiz.getQuizzes().get(0);
                Quiz.getQuizzes().set(0, q);
                Quiz.getQuizzes().set(index, temp);
                if (index > 5) return; // no need to switch their places if one does not appear on screen
                quiz1.setText(q.getQuizID());
                quiz1image.setImage(new Image("application/images/" + q.getSubject().getImageFilename()));
                switch (index) {
                    case 1:
                        quiz2.setText(temp.getSubject().getSubjectName());
                        quiz2image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 2:
                        quiz3.setText(temp.getSubject().getSubjectName());
                        quiz3image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 3:
                        quiz4.setText(temp.getSubject().getSubjectName());
                        quiz4image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 4:
                        quiz5.setText(temp.getSubject().getSubjectName());
                        quiz5image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
                        break;
                    case 5:
                        quiz6.setText(temp.getSubject().getSubjectName());
                        quiz6image.setImage(new Image("application/images/" + temp.getSubject().getImageFilename()));
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
    void initialize() {
        LoginController.setProfileText(username);
        labels.add(quiz1);
        labels.add(quiz2);
        labels.add(quiz3);
        labels.add(quiz4);
        labels.add(quiz5);
        labels.add(quiz6);
        ivs.add(quiz1image);
        ivs.add(quiz2image);
        ivs.add(quiz3image);
        ivs.add(quiz4image);
        ivs.add(quiz5image);
        ivs.add(quiz6image);

        int size = Quiz.getQuizzes().size();
        for (int i = 0; i < 6; i += 1) {
            if (i > size - 1) {
                labels.get(i).setOpacity(0);
                ivs.get(i).setOpacity(0);
                ivs.get(i).setCursor(Cursor.DEFAULT);
            } else {
                labels.get(i).setText(Quiz.getQuizzes().get(i).getQuizID());
                ivs.get(i).setImage(new Image("application/images/" + Quiz.getQuizzes().get(i).getSubject().getImageFilename()));
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

    private void openQuiz(Node event, int index) throws IOException {
        QuizController qc = switchScene(event, "/application/quiz.fxml").getController();
        Quiz selectedQuiz = Quiz.getQuizzes().get(index);
        qc.setSelectedQuiz(selectedQuiz);
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
}
