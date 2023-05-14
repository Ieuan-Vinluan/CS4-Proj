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
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
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
    private Label title1;

    @FXML
    private Label title2;

    @FXML
    private Label title3;

    @FXML
    private Label title4;

    @FXML
    private Label title5;

    @FXML
    private Label title6;

    @FXML
    private Label title7;

    @FXML
    private Label username;

    @FXML
    private Label playingSong;

    @FXML
    private Button playBtn;

    @FXML
    private Button pauseBtn;

    @FXML
    private Button restartBtn;

    private ArrayList<Song> songs = Song.getSongs();

    private ArrayList<Label> artists = new ArrayList<>();

    private ArrayList<Label> songTitles = new ArrayList<>();

    private ArrayList<Label> dateAdded = new ArrayList<>();

    private ArrayList<Label> durations = new ArrayList<>();

    private ArrayList<Button> playBtns = new ArrayList<>();

    private MediaPlayer mp;

    private Song currentSong;

    private Duration currentTime;

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
    void playSong(ActionEvent event) throws URISyntaxException {
        Button clicked = (Button) event.getSource();
        String idOfClicked = clicked.getId();

        if (idOfClicked.equals("playBtn")) {
            mp.seek(currentTime);
            mp.play();
            return;
        }

        try {
            if (idOfClicked.contains("1")) currentSong = songs.get(0);
            else if (idOfClicked.contains("2")) currentSong = songs.get(1);
            else if (idOfClicked.contains("3")) currentSong = songs.get(2);
            else if (idOfClicked.contains("4")) currentSong = songs.get(3);
            else if (idOfClicked.contains("5")) currentSong = songs.get(4);
            else if (idOfClicked.contains("6")) currentSong = songs.get(5);
            else if (idOfClicked.contains("7")) currentSong = songs.get(6);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index is too big!");
            return;
        }
        mp.stop();
        try {
            mp = new MediaPlayer(new Media(getClass().getResource("music/" + currentSong.getFilePath()).toURI().toString()));
        } catch (NullPointerException e) {
            Media media = new Media(currentSong.getFilePath());
            mp = new MediaPlayer(media);
        }
        currentSong.setPlaying(true);
        playingSong.setText(currentSong.getTitle());
        mp.play();
    }

    @FXML
    void playBtnEnter(MouseEvent event) {
        playBtn1.setText("");
        playBtn2.setText("");
        playBtn3.setText("");
        playBtn4.setText("");
        playBtn5.setText("");
        playBtn6.setText("");
        playBtn7.setText("");
    }

    @FXML
    void playBtnExit(MouseEvent event) {
        playBtn1.setText("1");
        playBtn2.setText("2");
        playBtn3.setText("3");
        playBtn4.setText("4");
        playBtn5.setText("5");
        playBtn6.setText("6");
        playBtn7.setText("7");
    }

    @FXML
    void pauseSong(ActionEvent event) {
        currentTime = mp.getCurrentTime();
        currentSong.setPlaying(false);
        mp.pause();
    }

    @FXML
    void restartSong(ActionEvent event) {
        mp.seek(Duration.valueOf("0s"));
        currentSong.setPlaying(true);
        mp.play();
    }

    @FXML
    void initialize() {
        LoginController.setProfileText(username);
        playingSong.setText("");

        artists.add(artist1);
        artists.add(artist2);
        artists.add(artist3);
        artists.add(artist4);
        artists.add(artist5);
        artists.add(artist6);
        artists.add(artist7);

        dateAdded.add(added1);
        dateAdded.add(added2);
        dateAdded.add(added3);
        dateAdded.add(added4);
        dateAdded.add(added5);
        dateAdded.add(added6);
        dateAdded.add(added7);

        songTitles.add(title1);
        songTitles.add(title2);
        songTitles.add(title3);
        songTitles.add(title4);
        songTitles.add(title5);
        songTitles.add(title6);
        songTitles.add(title7);

        durations.add(duration1);
        durations.add(duration2);
        durations.add(duration3);
        durations.add(duration4);
        durations.add(duration5);
        durations.add(duration6);
        durations.add(duration7);

        playBtns.add(playBtn1);
        playBtns.add(playBtn2);
        playBtns.add(playBtn3);
        playBtns.add(playBtn4);
        playBtns.add(playBtn5);
        playBtns.add(playBtn6);
        playBtns.add(playBtn7);

        for (int i = 0; i < 7; i += 1) {
            if (i <= songs.size() - 1) {
                setDetails(songs.get(i), i);
            } else {
                playBtns.get(i).setVisible(false);
                songTitles.get(i).setVisible(false);
                artists.get(i).setVisible(false);
                durations.get(i).setVisible(false);
                dateAdded.get(i).setVisible(false);
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

    private void setDetails(Song song, int index) {
        Media media;
        try {
            media = new Media(getClass().getResource("music/" + song.getFilePath()).toURI().toString());
            mp = new MediaPlayer(media);
            Media finalMedia = media;
            mp.setOnReady(() -> {
                songTitles.get(index).setText(song.getTitle());
                artists.get(index).setText(song.getArtist());
                dateAdded.get(index).setText(song.getAdded());
                durations.get(index).setText(String.format("%dm %ds", (int) Math.floor(finalMedia.getDuration().toSeconds() / 60), Math.round(finalMedia.getDuration().toSeconds() % 60)));
            });
        } catch (NullPointerException e) {
            media = new Media(song.getFilePath());
            mp = new MediaPlayer(media);
            Media finalMedia1 = media;
            mp.setOnReady(() -> {
                songTitles.get(index).setText(song.getTitle());
                artists.get(index).setText(song.getArtist());
                dateAdded.get(index).setText(song.getAdded());
                durations.get(index).setText(String.format("%dm %ds", (int) Math.floor(finalMedia1.getDuration().toSeconds() / 60), Math.round(finalMedia1.getDuration().toSeconds() % 60)));
            });
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }
}
