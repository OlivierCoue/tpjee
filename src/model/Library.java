package model;

import java.util.ArrayList;
import java.util.List;

public class Library {
	
	private int id;
	private String name;
	private final List<Item> items;
	
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
