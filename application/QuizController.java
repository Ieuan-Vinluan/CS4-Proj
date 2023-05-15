package application;

import application.model.Question;
import application.model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class QuizController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button backBtn;

    @FXML
    private AnchorPane box1;

    @FXML
    private AnchorPane box2;

    @FXML
    private Button finish;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Button nextBtn;

    @FXML
    private Button playlists;

    @FXML
    private Label question1;

    @FXML
    private TextArea question1text;

    @FXML
    private Label question2;

    @FXML
    private TextArea question2text;

    @FXML
    private Label quizID;

    @FXML
    private Label quizSubject;

    @FXML
    private Button quizzes;

    @FXML
    private Button subject;

    @FXML
    private Label username;

    private Quiz selectedQuiz;

    private ArrayList<Question> questions = new ArrayList<>();

    private ArrayList<String> answers = new ArrayList<>();

    private ArrayList<AnchorPane> anchorpanes = new ArrayList<>();

    private int index = 0;

    @FXML
    void finish(ActionEvent event) throws IOException {
        selectedQuiz.setCurrentScore(0);
        System.out.println(answers);
        for (int i = 0; i < answers.size(); i += 1) {
            if (questions.get(i).getAnswer().equalsIgnoreCase(answers.get(i))) {
                selectedQuiz.setCurrentScore(selectedQuiz.getCurrentScore() + 1);
            }
        }
        System.out.println(selectedQuiz.getCurrentScore());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("The quiz is finished!");
        alert.setContentText(String.format("Your score is: %d/%d, or %.2f", selectedQuiz.getCurrentScore(), selectedQuiz.getHighestPossibleScore(), (double) selectedQuiz.getCurrentScore() / selectedQuiz.getHighestPossibleScore() * 100));
        alert.showAndWait();

        // send the user back to the home screen
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goBack(ActionEvent event) {
        // go back
        index -= 1;

        // update buttons
        if (index == 0) {
            backBtn.setDisable(true);
        }
        nextBtn.setDisable(false);

        updateQuestions();
        updateAnswers();
    }

    @FXML
    void goNext(ActionEvent event) {
        // go to the next two questions
        index += 1;

        // update buttons
        if (index == (questions.size() - 1) / 2) {
            nextBtn.setDisable(true);
        }
        backBtn.setDisable(false);

        updateQuestions();
        updateAnswers();
    }

    @FXML
    void recordAnswers(KeyEvent event) {
        TextArea textAreaTyped = (TextArea) event.getSource();
        String id = textAreaTyped.getId();

        if (id.equalsIgnoreCase("question1text")) {
            answers.set(2 * index, question1text.getText());
        } else {
            answers.set(2 * index + 1, question2text.getText());
        }
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToPlaylists(ActionEvent event) throws IOException {
        PlaylistController pc = switchScene((Node) event.getSource(), "/application/playlist.fxml").getController();
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
    }

    @FXML
    void initialize() {
        // initialization
        anchorpanes.add(box1);
        anchorpanes.add(box2);
        backBtn.setDisable(true);
        if (questions.size() == 1 || questions.size() == 2) nextBtn.setDisable(true);
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

    private void updateQuestions() {
        try {
            // updating box1
            box1.setVisible(true);
            question1.setText(questions.get(2 * index).getQuestion());
            question1text.setText(answers.get(2 * index));
        } catch (IndexOutOfBoundsException e) {
            // if no question exists at the index (2 * index), hide box1
            box1.setVisible(false);
        }
        try {
            // updating box2
            box2.setVisible(true);
            question2.setText(questions.get(2 * index + 1).getQuestion());
            question2text.setText(answers.get(2 * index + 1));
        } catch (IndexOutOfBoundsException e) {
            // if no question exists at the index (2 * index + 1), hide box2
            box2.setVisible(false);
        }
    }

    private void updateAnswers() {
        // update contents of TextAreas
        question1text.setText(answers.get(2 * index));
        if (answers.size() % 2 == 0) question2text.setText(answers.get(2 * index + 1));
    }

    public void setQuestionText(int index, String text) {
        if (index == 0) {
            question1.setText(text);
        } else if (index == 1) {
            question2.setText(text);
        } else {
            System.out.println("Error!");
        }
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public ArrayList<AnchorPane> getAnchorpanes() {
        return anchorpanes;
    }

    public TextArea getQuestion2text() {
        return question2text;
    }

    public Label getQuizSubject() {
        return quizSubject;
    }

    public Label getQuizID() {
        return quizID;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public Quiz getSelectedQuiz() {
        return selectedQuiz;
    }

    public void setSelectedQuiz(Quiz selectedQuiz) {
        this.selectedQuiz = selectedQuiz;
    }
}
