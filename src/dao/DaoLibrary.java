package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Item;
import model.Library;

public class DaoLibrary {
	
	public static List<Library> getAllDemo(){
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
	
	public static int save(Library obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		int i=(Integer)session.save(obj);
		t.commit();
		
		session.close();
		
		return i;
	}
	
	public static void saveOrUpdate(Library obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		session.saveOrUpdate(obj);
		t.commit();
		
		session.close();
	}
	
	public void delete(Library obj){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		session.delete(obj);
		t.commit();
		
		session.close();
	}
	
	public Library get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		Library lib = session.get(Library.class, id);
		t.commit();
		
		session.close();
		return lib;
	}

	public Library merge(Library obj){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		Library lib = (Library) session.merge(obj);
		t.commit();
		
		session.close();
		return lib;
	}
	
	public List<Library> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		CriteriaQuery<Library> cq = session.getCriteriaBuilder().createQuery(Library.class);
		cq.from(Library.class);
		List<Library> libraryList = session.createQuery(cq).getResultList();
		
		t.commit();
		
		session.close();
		return libraryList;
	}
}
