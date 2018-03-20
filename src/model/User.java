package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id @GeneratedValue
	private int id;
	private String username;
	@Column(unique = true)
	private String email;
	private String password;
	private boolean isAdmin;
	
	public User() {}
	
	public User(String username, String email, String password, boolean isAdmin) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public User(int id, String username, String email, String password, boolean isAdmin) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	public static String hashPassword(String password) {
		
		byte[] salt = "hellothisismysecretsalt".getBytes();
		String hash = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        
        return hash;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
