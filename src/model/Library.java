package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Library")

public class Library {

	@Id @GeneratedValue
	private int id;
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="library")
	private final List<Item> items;
	
	
	public Library() {
		this.items = new ArrayList<Item>();
	}
	
	public Library(String name) {
		super();
		this.name = name;
		this.items = new ArrayList<Item>();
	}
	
	public Library(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.items = new ArrayList<Item>();
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public List<Item> getItems(){
		return items;
	}
	
	public int getItemsCount() {
		return this.items.size();
	}

}
