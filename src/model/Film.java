package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Film")

public class Film extends Video {

	@Id @GeneratedValue
	private int id;
	
	private String title, director;

	public Film(String filename, String title, String director) {
		super(filename);
		this.title = title;
		this.director = director;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
}
