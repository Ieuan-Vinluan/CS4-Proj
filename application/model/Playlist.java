package application.model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Playlist class is a container of Songs. It has a name and an ArrayList of contained Songs. Like playlists in other music players, one can add Songs to the Playlist, remove Songs from the Playlist, and shuffle the order of the Songs.
 */
public class Playlist {
    /**
     * The name of the Playlist
     */
    private String name;
    /**
     * The ArrayList of Songs contained by the Playlist
     */
    private ArrayList<Song> songs = new ArrayList<>();
    /**
     * The ArrayList of all created Playlists
     */
    private static ArrayList<Playlist> playlists = new ArrayList<>();

    /**
     * @param name the name of the Playlist
     */
    public Playlist(String name) {
        this.name = name;
        playlists.add(this);
    }

    /**
     * Returns the name of the Playlist
     *
     * @return the name of the Playlist
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the Playlist
     *
     * @param name the new name of the Playlist
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the ArrayList of all created Playlists
     *
     * @return the ArrayList of all created Playlists
     */
    public static ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    /**
     * Sets the ArrayList of all created Playlists to another ArrayList containing Playlists
     *
     * @param playlists the new ArrayList containing Playlists
     */
    public static void setPlaylists(ArrayList<Playlist> playlists) {
        Playlist.playlists = playlists;
    }

    /**
     * Returns the ArrayList of Songs contained by this Playlist
     *
     * @return the ArrayList of Songs contained by this Playlist
     */
    public ArrayList<Song> getSongs() {
        return songs;
    }

    /**
     * Sets the ArrayList of Songs contained by this Playlist
     *
     * @param songs the new ArrayList of Songs that will be contained by this Playlist
     */
    public void setSongs(ArrayList<Song> songs) {
        this.songs = songs;
    }

    /**
     * Adds a Song to the ArrayList of Songs contained by the Playlist
     *
     * @param song the Song to be added to the ArrayList of Songs contained by the Playlist
     */
    public void addSong(Song song) {
        songs.add(song);
    }

    /**
     * Removes a Song from the ArrayList of Songs contained by the Playlist
     *
     * @param song the Song to be removed from the ArrayList of Songs contained by the Playlist
     */
    public void removeSong(Song song) {
        songs.remove(song);
    }

    /**
     * Shuffles the order of the Songs contained by the Playlist in the ArrayList
     */
    public void shuffle() {
        Collections.shuffle(songs);
    }
}