package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import model.Item;
import model.Library;
import model.User;

public class DaoUser {
	
	public static User getOne(String username, String password) {
		if(username.equals("admin"))
			return new User(1, "Olivier", "email", "Coué", true);
		else if (username.equals("test"))
			return new User(1, "Olivier", "email", "Coué", false);
		else 
			return null;
	}
	
	public static int save(User obj) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		int i=(Integer)session.save(obj);
		session.getTransaction().commit();
		
		session.close();
		
		return i;
	}
	
	public static User get(String email){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query query = (Query) session.createQuery("from User where email = :email");
		query.setString("email", email);
		
		User user = (User) query.uniqueResult();
		
		session.close();
		return user;
	}
	
}
