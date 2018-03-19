package dao;

import model.User;

public class DaoUser {
	
	public static User getOne(String username, String password) {
		if(username.equals("admin"))
			return new User(1, "Olivier", "Coué", true);
		else if (username.equals("test"))
			return new User(1, "Olivier", "Coué", false);
		else 
			return null;
	}
	
}
