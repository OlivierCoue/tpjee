package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MusicFile")

public class MusicFile extends Item {
	@Id @GeneratedValue
	private int id;
	private String name, artist, album;
	public MusicFile(String filename, String name, String artist, String album) {
		super(filename);
		this.name = name;
		this.artist = artist;
		this.album = album;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public String getAlbum() {
		return album;
	}
	
	public void setAlbum(String album) {
		this.album = album;
	}
	
	public int getId() {
		return id;
	}
}
