package model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="MusicalVideo")

public class MusicalVideo extends Video {
	
	@OneToOne(cascade = CascadeType.ALL)
	private MusicFile musicFile;
	
	public MusicalVideo(int id, String filename, MusicFile musicFile) {
		super(id, filename);
		this.musicFile = musicFile;
	}

	public MusicFile getMusicFile() {
		return musicFile;
	}

	public void setMusicFile(MusicFile musicFile) {
		this.musicFile = musicFile;
	}
}
