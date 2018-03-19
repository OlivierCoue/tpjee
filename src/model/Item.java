package model;

public class Item {
	
	private int id;
	private String filename;

	public Item(int id, String filename) {
		super();
		this.id = id;
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
