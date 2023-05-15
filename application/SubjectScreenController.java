package application;

import application.model.LearningGuide;
import application.model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class SubjectScreenController {

    @FXML
    private Button home;

    @FXML
    private Label mod1;

    @FXML
    private Label mod2;

    @FXML
    private Label mod3;

    @FXML
    private Label mod4;

    @FXML
    private Label mod5;

    @FXML
    private Button modules;

    @FXML
    private Button playlists;

    @FXML
    private Label quiz1;

    @FXML
    private Label quiz2;

    @FXML
    private Label quiz3;

    @FXML
    private Label quiz4;

    @FXML
    private Label quiz5;

    @FXML
    private HBox lgBox1;

    @FXML
    private HBox lgBox2;

    @FXML
    private HBox lgBox3;

    @FXML
    private HBox lgBox4;

    @FXML
    private HBox lgBox5;

    @FXML
    private HBox quizBox1;

    @FXML
    private HBox quizBox2;

    @FXML
    private HBox quizBox3;

    @FXML
    private HBox quizBox4;

    @FXML
    private HBox quizBox5;

    @FXML
    private Button quizzes;

    @FXML
    private Button subject;

    @FXML
    private Label subjectName;

    @FXML
    private Label username;

    private ArrayList<Label> moduleLabels = new ArrayList<>();
    private ArrayList<Label> quizLabels = new ArrayList<>();

    private ArrayList<LearningGuide> lgs = new ArrayList<>();
    private ArrayList<Quiz> subjectQuizzes = new ArrayList<>();

    private ArrayList<HBox> lgHBoxes = new ArrayList<>();

    private ArrayList<HBox> quizHBoxes = new ArrayList<>();

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
    void goToModule(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) throws IOException {
        PlaylistController pc = switchScene((Node) actionEvent.getSource(), "/application/playlist.fxml").getController();
    }

    @FXML
    void goToQuizzes(ActionEvent actionEvent) throws IOException {
        QuizzesController qc = switchScene((Node) actionEvent.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void initialize() {
        LoginController.setProfileText(username);

        moduleLabels.add(mod1);
        moduleLabels.add(mod2);
        moduleLabels.add(mod3);
        moduleLabels.add(mod4);
        moduleLabels.add(mod5);

        quizLabels.add(quiz1);
        quizLabels.add(quiz2);
        quizLabels.add(quiz3);
        quizLabels.add(quiz4);
        quizLabels.add(quiz5);

        lgHBoxes.add(lgBox1);
        lgHBoxes.add(lgBox2);
        lgHBoxes.add(lgBox3);
        lgHBoxes.add(lgBox4);
        lgHBoxes.add(lgBox5);

        quizHBoxes.add(quizBox1);
        quizHBoxes.add(quizBox2);
        quizHBoxes.add(quizBox3);
        quizHBoxes.add(quizBox4);
        quizHBoxes.add(quizBox5);
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
        Label clicked = (Label) event.getSource();
        String id = clicked.getText();
        LearningGuide selectedLG = null;
        for (LearningGuide l : LearningGuide.getLearningGuides()) {
            if (l.getTitle().equalsIgnoreCase(id)) {
                selectedLG = l;
            }
        }

        if (selectedLG == null) return;

        ModuleController mc = switchScene((Node) event.getSource(), "/application/module.fxml").getController();
        mc.setPathText("Home > " + selectedLG.getSubject().getSubjectName() + " > " + selectedLG.getTitle());
        mc.setLGTitleText(selectedLG.getTitle());
        mc.setLgContentText(selectedLG.getContent());
    }

    @FXML
    void goToQuiz(MouseEvent event) throws IOException {
        Label clicked = (Label) event.getSource();
        String id = clicked.getText();
        Quiz selectedQuiz = null;
        for (Quiz q : Quiz.getQuizzes()) {
            if (q.getQuizID().equalsIgnoreCase(id)) {
                selectedQuiz = q;
            }
        }

        if (selectedQuiz == null) return;

        QuizController qc = switchScene((Node) event.getSource(), "/application/quiz.fxml").getController();
        qc.setSelectedQuiz(selectedQuiz);
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

    public ArrayList<LearningGuide> getLgs() {
        return lgs;
    }

    public void setLgs(ArrayList<LearningGuide> lgs) {
        this.lgs = lgs;
    }

    public ArrayList<Quiz> getSubjectQuizzes() {
        return subjectQuizzes;
    }

    public void setSubjectQuizzes(ArrayList<Quiz> subjectQuizzes) {
        this.subjectQuizzes = subjectQuizzes;
    }

    public ArrayList<Label> getModuleLabels() {
        return moduleLabels;
    }

    public ArrayList<Label> getQuizLabels() {
        return quizLabels;
    }

    public ArrayList<HBox> getLgHBoxes() {
        return lgHBoxes;
    }

    public ArrayList<HBox> getQuizHBoxes() {
        return quizHBoxes;
    }

    public void setSubjectNameText(String text) {
        this.subjectName.setText(text);
    }
}
