package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Library")

public class Library {

	@Id @generatedvalue
	private int id;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy="library")
	private final List<Item> items;
	
	public Library(String name) {
		super();
		this.name = name;
		this.items = new ArrayList<Item>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	public int getItemsCount() {
		return this.items.size();
	}

}
