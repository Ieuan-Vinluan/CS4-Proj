package application;

import application.model.LearningGuide;
import application.model.Note;
import application.model.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
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
    private Label note1;

    @FXML
    private Label note2;

    @FXML
    private Label note3;

    @FXML
    private Label note4;

    @FXML
    private Label note5;

    @FXML
    private Label note6;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button subject;

    private ArrayList<Label> lgs = new ArrayList<>();
    private ArrayList<Label> noteLabels = new ArrayList<>();

    // test lgs
    private LearningGuide firstLG;
    private LearningGuide secondLG;
    private LearningGuide thirdLG;
    private LearningGuide fourthLG;
    private LearningGuide fifthLG;
    private LearningGuide sixthLG;

    // test notes
    private LearningGuide firstNote;
    private LearningGuide secondNote;
    private LearningGuide thirdNote;
    private LearningGuide fourthNote;
    private LearningGuide fifthNote;
    private LearningGuide sixthNote;

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
    void openNote(MouseEvent event) throws IOException {
        Label label = (Label) event.getSource();
        String id = label.getId();
        if (id.contains("1")) {
            openSelectedNote(label, 0);
        } else if (id.contains("2")) {
            openSelectedNote(label, 1);
        } else if (id.contains("3")) {
            openSelectedNote(label, 2);
        } else if (id.contains("4")) {
            openSelectedNote(label, 3);
        } else if (id.contains("5")) {
            openSelectedNote(label, 4);
        } else if (id.contains("6")) {
            openSelectedNote(label, 5);
        }
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
        noteLabels.add(note1);
        noteLabels.add(note2);
        noteLabels.add(note3);
        noteLabels.add(note4);
        noteLabels.add(note5);
        noteLabels.add(note6);

        if (LearningGuide.getLearningGuides().size() < 5) {
            int lgSize = LearningGuide.getLearningGuides().size();
            for (int i = 0; i < 5; i += 1) {
                if (i >= lgSize) {
                    lgs.get(i).setOpacity(0); // hide
                } else {
                    lgs.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
                    lgs.get(i).setCursor(Cursor.HAND);
                }
            }
        } else {
            for (int i = 0; i < 5; i += 1) {
                lgs.get(i).setText(LearningGuide.getLearningGuides().get(i).getTitle());
                lgs.get(i).setCursor(Cursor.HAND);
            }
        }

        if (Note.getNotes().size() < 6) {
            int noteSize = Note.getNotes().size();
            for (int i = 0; i < 6; i += 1) {
                if (i >= noteSize) {
                    // hide
                    noteLabels.get(i).setOpacity(0);
                    noteLabels.get(i).setCursor(Cursor.DEFAULT);
                } else {
                    noteLabels.get(i).setText(Note.getNotes().get(i).getTitle());
                }
            }
        } else {
            for (int i = 0; i < 6; i += 1) {
                noteLabels.get(i).setText(Note.getNotes().get(i).getTitle());
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

    private void openSelectedNote(Node event, int index) throws IOException {
        NoteController nc = switchScene(event, "/application/note.fxml").getController();
        if (Note.getNotes().size() >= index + 1) {
            nc.setSelectedNote(Note.getNotes().get(index));
            nc.setNoteTitleText(nc.getSelectedNote().getTitle());
            nc.setNoteContentText(nc.getSelectedNote().getContent());
        }
    }

}
