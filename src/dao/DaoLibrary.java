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
	
	
	public static Library getById(int id) {
		Library lib = new Library(id, "lib " + id);
		for(int x=0; x<10; x++) {
			lib.addItem(new Item(x, "filename " +x));
		}
		return lib;
	}
	
	public static int save(Library obj) {
		System.out.println(obj.getId());
		System.out.println(obj.getName());
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		session.beginTransaction();
		int i=(Integer)session.save(obj);
		session.getTransaction().commit();
		
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
	
	public static Library get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Library lib = session.get(Library.class, id);
		session.getTransaction().commit();
		
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
	
	public static List<Library> getAll(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		CriteriaQuery<Library> cq = session.getCriteriaBuilder().createQuery(Library.class);
		cq.from(Library.class);
		List<Library> libraryList = session.createQuery(cq).getResultList();
		
		session.close();
		return libraryList;
	}
}
