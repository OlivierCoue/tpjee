package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class MusicalVideo extends Video {
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MusicFile musicFile;
	
	public MusicalVideo() {
	}
	
	public MusicalVideo(String filename, Library library, MusicFile musicFile) {
		super(filename, library);
		this.musicFile = musicFile;
	}

	public MusicFile getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(MusicFile musicFile) {
		this.musicFile = musicFile;
	}
}
