package model;

@Entity
@Table(name="Item")

public class Item {
	
	@Id @generatedvalue
	private int id;
	private String filename;

	public Item(String filename) {
		super();
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
}
