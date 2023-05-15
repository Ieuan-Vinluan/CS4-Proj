package application.model;

import java.util.ArrayList;

public class Song {
    private String title;
    private Playlist playlist;
    private String filePath;
    private String artist;
    private String added;
    private boolean isPlaying = false;
    private static ArrayList<Song> songs = new ArrayList<>();


    public Song(String title, String artist, String added, Playlist playlist, String filePath) {
        this.title = title;
        this.playlist = playlist;
        this.filePath = filePath;
        this.artist = artist;
        this.added = added;
        songs.add(this);
        for (Playlist p : Playlist.getPlaylists()) {
            if (p.equals(this.playlist)) {
                p.addSong(this);
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public boolean getPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    public static ArrayList<Song> getSongs() {
        return songs;
    }

    public static void setSongs(ArrayList<Song> songs) {
        Song.songs = songs;
    }

    public void toggleSong() {
        this.isPlaying = !this.isPlaying;
    }
}
