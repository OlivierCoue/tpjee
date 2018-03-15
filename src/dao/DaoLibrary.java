package dao;

import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Library;

public class DaoLibrary {
	
	public static List<Library> getAll(){
		List<Library> libs = new ArrayList<>();
		for(int i=0; i<10; i++) {
			Library lib = new Library("library"+i);
			for(int x=0; x<20; x++) {
				lib.addItem(new Item("filename" +x));
			}
			libs.add(lib);
		}
			
		return libs;
	}

}
