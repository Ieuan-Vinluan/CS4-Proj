package application.model;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
	private String name;
	private ArrayList<Song> songs = new ArrayList<>();
	private static ArrayList<Playlist> playlists = new ArrayList<>();
	
	public Playlist(String name) {
		this.name = name;
		playlists.add(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static ArrayList<Playlist> getPlaylists() {
		return playlists;
	}

	public static void setPlaylists(ArrayList<Playlist> playlists) {
		Playlist.playlists = playlists;
	}

	public ArrayList<Song> getSongs() {
		return songs;
	}

	public void setSongs(ArrayList<Song> songs) {
		this.songs = songs;
	}

	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void removeSong(Song song) {
		songs.remove(song);
	}
	
	public void shuffle() {
		Collections.shuffle(songs);
	}
	
	public void playSong(int indexOfSong) {
		if (!songs.get(indexOfSong).getPlaying()) songs.get(indexOfSong).toggleSong();
	}
	
	public void playSong(Song song) {
		if (!song.getPlaying()) song.toggleSong();
	}
}