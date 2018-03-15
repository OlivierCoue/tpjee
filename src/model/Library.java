package model;

import java.util.ArrayList;
import java.util.List;

public class Library {

	private String name;
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