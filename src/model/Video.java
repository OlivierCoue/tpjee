package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Video")

public class Video extends Item {

	@Id @GeneratedValue
	private int id;
	public Video(String filename) {
		super(filename);
	}
	
	public int getId() {
		return id;
	}
}
