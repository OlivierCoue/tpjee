package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="Item")

public class Item {
	
	@Id @GeneratedValue
	private int id;
	private String filename;

	public Item(String filename) {
		super();
		this.filename = filename;
	}
	
	public int getId() {
		return id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
