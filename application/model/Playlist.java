package application.model;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
	private String name;
	private ArrayList<Song> songs = new ArrayList<>();
	
	public Playlist(String name) {
		this.name = name;
	}

	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void removeSong(Song song) {
		if (songs.contains(song)) songs.remove(song);
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