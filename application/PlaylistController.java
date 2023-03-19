package application;

import application.model.Song;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PlaylistController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label added1;

    @FXML
    private Label added2;

    @FXML
    private Label added3;

    @FXML
    private Label added4;

    @FXML
    private Label added5;

    @FXML
    private Label added6;

    @FXML
    private Label added7;

    @FXML
    private Label artist1;

    @FXML
    private Label artist2;

    @FXML
    private Label artist3;

    @FXML
    private Label artist4;

    @FXML
    private Label artist5;

    @FXML
    private Label artist6;

    @FXML
    private Label artist7;

    @FXML
    private Label duration1;

    @FXML
    private Label duration2;

    @FXML
    private Label duration3;

    @FXML
    private Label duration4;

    @FXML
    private Label duration5;

    @FXML
    private Label duration6;

    @FXML
    private Label duration7;

    @FXML
    private Button home;

    @FXML
    private Button modules;

    @FXML
    private Button playBtn1;

    @FXML
    private Button playBtn2;

    @FXML
    private Button playBtn3;

    @FXML
    private Button playBtn4;

    @FXML
    private Button playBtn5;

    @FXML
    private Button playBtn6;

    @FXML
    private Button playBtn7;

    @FXML
    private Button playlists;

    @FXML
    private Button quizzes;

    @FXML
    private Button subject;

    @FXML
    private Label time1;

    @FXML
    private Label time2;

    @FXML
    private Label time3;

    @FXML
    private Label time4;

    @FXML
    private Label time5;

    @FXML
    private Label time6;

    @FXML
    private Label time7;

    @FXML
    private Label username;

    private ArrayList<Song> songs = Song.getSongs();

    private ArrayList<Media> mediaArrayList = new ArrayList<>();

    private MediaPlayer mp;

    @FXML
    void goToHome(ActionEvent event) throws IOException {
        switchScene((Node) event.getSource(), "/application/homescreen.fxml");
    }

    @FXML
    void goToModule(ActionEvent event) throws IOException {
        switchScene((Node) event.getSource(), "/application/modulescreen.fxml");
    }

    @FXML
    void goToPlaylist(ActionEvent event) throws IOException {
        switchScene((Node) event.getSource(), "/application/playlist.fxml");
    }

    @FXML
    void goToQuizzes(ActionEvent event) throws IOException {
        switchScene((Node) event.getSource(), "/application/quizzes.fxml");
    }

    @FXML
    void goToSubject(ActionEvent event) throws IOException {
        switchScene((Node) event.getSource(), "/application/subject.fxml");
    }

    @FXML
    void playSong(ActionEvent event) {
        mp = new MediaPlayer(mediaArrayList.get(0));
        mp.play();
    }

    @FXML
    void initialize() {
        for (Song s : this.songs) {
            mediaArrayList.add(new Media(new File("application/music/" + s.getFilePath()).toURI().toString()));
        }
        System.out.println(mediaArrayList);
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
