package application;

import application.model.Playlist;
import application.model.Song;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaylistCreateScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addSong;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Button playlists;

    @FXML
    private Button quizzes;

    @FXML
    private Button subject;

    @FXML
    private Button submitBtn;

    @FXML
    private TextArea titleText;

    @FXML
    private Label username;

    private ArrayList<Song> createdSongs = new ArrayList<Song>();

    private Playlist createdPlaylist = new Playlist("placeholder");

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        SubjectController sc = switchScene((Node) event.getSource(), "/application/subject.fxml").getController();
        System.out.println("Successfully opened Subjects"); // debug purposes
    }

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        HomeScreenController hsc = switchScene((Node) event.getSource(), "/application/homescreen.fxml").getController();
    }

    @FXML
    void goToModules(ActionEvent event) throws IOException {
        ModuleScreenController msc = switchScene((Node) event.getSource(), "/application/modulescreen.fxml").getController();
    }

    @FXML
    void goToPlaylists(ActionEvent actionEvent) throws IOException {
        PlaylistController pc = switchScene((Node) actionEvent.getSource(), "/application/playlist.fxml").getController();
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        QuizzesController qc = switchScene((Node) event.getSource(), "/application/quizzes.fxml").getController();
    }

    @FXML
    void submitText(ActionEvent event) throws IOException {
        createdPlaylist.setName(titleText.getText());
        switchScene((Node) event.getSource(), "/application/homescreen.fxml");
    }

    @FXML
    void addSong(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
//        String url = getClass().getResource("music").toString();
//        url = url.replaceAll("%20", " ");
//        url = url.replaceAll("file:/", "");
//        fileChooser.setInitialDirectory(new File(url));
        File song = fileChooser.showOpenDialog(new Stage());
        String path = song.toURI().toString();
//        path = song.getAbsolutePath().substring(path.indexOf("music") + 6, path.length());
        LocalDate today = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String todayDate = today.format(dtf);
        /*
         maybe we can add a separate TextArea for the artist? but I don't really
         think it's that important
         */
        createdSongs.add(new Song(song.getName().substring(0, (int) (song.getName().length() - 4)), "Unknown", todayDate, createdPlaylist, path));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Added Song!");
        alert.setContentText("The song " + song.getName().substring(0, (int) (song.getName().length() - 4)) + " was successfully added.");
        alert.showAndWait();
    }

    @FXML
    void initialize() {

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
