package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
public class Video extends Item {

	public Video(int id, String filename) {
		super(id, filename);
	}
	
	public Video(String filename, Library library) {
		super(filename, library);
	}
	
	public Video() {};
	
}
