package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Film extends Video {
	
	private String title, director;
	
	public Film() {}
	
	public Film(int id, String filename) {
		super(id, filename);
	}

	public Film(String filename, Library library, String title, String director) {
		super(filename, library);
		this.title = title;
		this.director = director;
	}
	
	public Film(int id, String filename, String title, String director) {
		super(id, filename);
		this.title = title;
		this.director = director;
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
