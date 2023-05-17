package application.model;

import java.util.ArrayList;

/**
 * The Song class represents a song that can be played on music players. It has a title, a Playlist to which it belongs, the file path to the song's mp3 file (or, if the mp3 file is in the "music" folder of the project, the mp3 file's filename), the name of the artist who made the song, the date on which the Song was added to the music player, and a boolean value indicating whether the Song is currently playing or not.
 */
public class Song {
    /**
     * The title of the Song
     */
    private String title;
    /**
     * The Playlist that contains the Song
     */
    private Playlist playlist;
    /**
     * The filepath to the Song's mp3 file
     */
    private String filePath;
    /**
     * The name of the artist who made the song
     */
    private String artist;
    /**
     * The date on which the Song was added to the music player
     */
    private String added;
    /**
     * A boolean value indicating whether the Song is currently playing or not
     */
    private boolean isPlaying = false;
    /**
     * An ArrayList containing all created Songs
     */
    private static ArrayList<Song> songs = new ArrayList<>();

    /**
     * @param title    the title of the Song
     * @param artist   the name of the artist who made the song
     * @param added    the date on which the Song was added to the music player
     * @param playlist the Playlist that contains the Song
     * @param filePath the file path to the Song's mp3 file
     */
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

    /**
     * Returns the title of the Song
     *
     * @return the title of the Song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the Song
     *
     * @param title the new title of the Song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns the Playlist that contains the Song
     *
     * @return the Playlist that contains the Song
     */
    public Playlist getPlaylist() {
        return playlist;
    }

    /**
     * Sets the Playlist that contains the Song
     *
     * @param playlist the new Playlist that will contain the Song
     */
    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    /**
     * Returns the name of the artist who made the Song
     *
     * @return the name of the artist who made the Song
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the name of the artist who made the song
     *
     * @param artist the name of the artist who made the song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Returns the file path of the Song's mp3 file
     *
     * @return the file path of the Song's mp3 file
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the file path that points to the Song's mp3 file
     *
     * @param filePath the new file path that will point to the Song's mp3 file
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Returns the date on which the Song was added to the music player
     *
     * @return the date on which the Song was added to the music player
     */
    public String getAdded() {
        return added;
    }

    /**
     * Sets the date on which the Song was added to the music player
     *
     * @param added the date on which the Song was added to the music player
     */
    public void setAdded(String added) {
        this.added = added;
    }

    /**
     * Returns the boolean value that indicates whether the Song is playing or not
     *
     * @return the boolean value that indicates whether the Song is playing or not
     */
    public boolean getPlaying() {
        return isPlaying;
    }

    /**
     * Sets the boolean value that indicates whether the Song is playing or not
     *
     * @param isPlaying the boolean value that indicates whether the Song is playing or not
     */
    public void setPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    /**
     * Returns the ArrayList of all created Songs
     *
     * @return the ArrayList of all created Songs
     */
    public static ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Sets the ArrayList of all created Songs to another ArrayList containing Songs
     *
     * @param songs an ArrayList containing Songs
     */
    public static void setSongs(ArrayList<Song> songs) {
        Song.songs = songs;
    }

    /**
     * Toggles the "playing state" of the Song. If it is playing, then the Song is paused (i.e., the 'isPlaying' field is set to false). If it is not playing, then the Song is played (i.e., the 'isPlaying' field is set to true).
     */
    public void toggleSong() {
        this.isPlaying = !this.isPlaying;
    }
}
