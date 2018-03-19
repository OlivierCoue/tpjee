package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Item;

public class DaoItem {
	public static int register(Item obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		t.begin();
		
		int i=(Integer)session.save(obj);
		t.commit();
		session.close();
		
		return i;
	}
}
