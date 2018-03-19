package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
	
	public static int register(Library obj) {
		Session session = new Configuration().
				configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		int i=(Integer)session.save(obj);
		t.commit();
		session.close();
		
		return i;
	}

}
