package model;
public class Song {
	private String title;
	private Playlist playlist;
	private String filePath;
	private boolean isPlaying = false;
	
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
	
	public String getFilePath() {
		return filePath;
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public boolean getPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public void toggleSong() {
		this.isPlaying = !this.isPlaying;
		if (this.isPlaying) {
			// code that plays the song
		} else {
			// code that pauses the song
		}
	}
}
