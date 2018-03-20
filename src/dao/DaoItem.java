package dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import model.Item;
import model.Library;

public class DaoItem {
	
	public static int save(Item obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		int i=(Integer)session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		
		return i;
	}
	
	public static Item get(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Item item = session.get(Item.class, id);
		session.getTransaction().commit();
		
		session.close();
		return item;
	}
	
	public static List<Item> getByLibrary(int libId){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = (Query) session.createQuery("from Item where library = :libId");
		query.setInteger("libId", libId);
		
		List<Item> items = query.list();
		
		session.close();
		return items;
	}
	
	
	public static List<Item> searchInLibrary(int libId, String rq, String type){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
	
		Query query;
		
		if(rq!=null && !rq.trim().isEmpty()) {
			System.out.println("EMPTYYYYYY");
			query = (Query) session.createQuery("from "+type+" where library = :libId and filename LIKE :rq");
			query.setInteger("libId", libId);
			query.setString("rq", "%" + rq + "%");
		}else {
			System.out.println("NOOOOT");
			query = (Query) session.createQuery("from "+type+" where library = :libId ");
			query.setInteger("libId", libId);
		}
	
		List<Item> items = query.list();
		
		session.close();
		return items;
	}
	
}
